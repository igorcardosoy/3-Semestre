#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
#include "queue.h"

#define BUFFER_SIZE 100
#define COMMAND_SIZE 200
#define ARGS_SIZE 20

void type_prompt();
void read_command(char*, char**);
void internal_commands(char**);
void external_commands(char**);
void history_command(Queue, char*);
void broke_string(char*, char**);
void clean_buffer(char*, char**);
char* get_directory();
char* get_username();
char* get_hostname();
struct tm* get_time();


int main()
{
    Queue history;
    bool exit = false;

    init(&history);

    system("clear");

    while (!exit) {

        char command[COMMAND_SIZE];
        char* parameters[ARGS_SIZE];
        int status = 0;

        type_prompt();
        read_command(command, parameters);

        enqueue(history, command);

        if (!strcmp(command, "exit")) { exit = true; }
        if (!exit) {

            if (!strcmp(command, "history\n")) {
                history_command(history, command);
                broke_string(command, parameters);
            }

            internal_commands(parameters);

            get_directory();

            external_commands(parameters);

            clean_buffer(command, parameters);
        }

    }

    return 0;
}

void clean_buffer(char* command, char* parameters[])
{
    command = NULL;

    for (int i = 0; parameters[i] != NULL; i++) {
        parameters[i] = NULL;
    }
}

void history_command(Queue history, char* command)
{
    int queue_size = size(history);

    for (int i = 0; i < queue_size; i++) {
        char* temp_string;
        temp_string = dequeue(history);
        enqueue(history, temp_string);
        printf("[%d]: %s\n", i + 1, temp_string);
    }

    char* string = malloc(sizeof(char) * BUFFER_SIZE);

    fgets(string, BUFFER_SIZE, stdin);

    string = strtok(string, "!");

    int index = atoi(string);

    for (int i = 0; i < queue_size; i++) {
        char* temp_string;
        temp_string = dequeue(history);
        enqueue(history, temp_string);

        if (i == index - 1)
            command = temp_string;
    }

    enqueue(history, command);
}

void type_prompt()
{
    struct tm* time = get_time();
    printf("%s@%s[%02d:%02d:%02d] caminho $ ", get_username(), get_hostname(), time->tm_hour, time->tm_min, time->tm_sec);
}

char* get_directory()
{
    char * buf;
    char * cwd;
    buf = (char *)malloc(sizeof(char) * 1024);

    cwd = getcwd(buf, 1024);

    

    return 0;
}

struct tm* get_time()
{
    time_t segundos;
    time(&segundos);

    return localtime(&segundos);
}

char* get_username()
{
    char* username = getenv("USER");
    return username;
}

char* get_hostname()
{
    char* hostname = malloc(sizeof(char) * 100);
    gethostname(hostname, 100);
    return hostname;
}

void internal_commands(char* parameters[])
{
    if (!strcmp(parameters[0], "cd")) {
        if (parameters[1] == NULL) {
            chdir(getenv("HOME"));
        } else {
            chdir(parameters[1]);
        }
    }
}

void external_commands(char* parameters[])
{
    int status;

    if (fork() != 0) {
        waitpid(-1, &status, 0);
    } else {
        if (execvp(parameters[0], parameters) == -1) {
            _exit(1);
        }
        perror("execvp");
    }
}

void read_command(char* command, char* parameters[])
{
    fgets(command, BUFFER_SIZE, stdin);
    broke_string(command, parameters);
}

void broke_string(char* command, char* parameters[])
{
    char* token;

    command[strlen(command) - 1] = '\0';
    token = strtok(command, " ");

    strcpy(command, token);

    int i = 1;
    while (token != NULL) {
        token = strtok(NULL, " ");
        if (token != NULL) {
            parameters[i] = malloc(sizeof(char) * BUFFER_SIZE);
            snprintf(parameters[i], BUFFER_SIZE, "%s", token);
        }

        i++;
    }

    parameters[0] = malloc(sizeof(char) * BUFFER_SIZE);
    snprintf(parameters[0], sizeof(command), "%s", command);

    parameters[i] = NULL;
}