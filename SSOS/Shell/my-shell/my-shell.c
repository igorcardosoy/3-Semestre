#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
#include "queue.h"

#define BUFFER_SIZE 300

void type_prompt();
void read_command(char*, char*);
void my_exit(int code);
void intern_commands(char command[]);
void history_command(Queue history, char* command);
void broke_string(char* command);
struct tm* get_time();


int main(){
    Queue history; 

    init(&history);

    do{

        char* command = malloc(sizeof(char) * BUFFER_SIZE);
        char* parameters = malloc(sizeof(char) * BUFFER_SIZE);

        type_prompt();
        read_command(command, parameters);

        enqueue(history, command);

        if (!strcmp(command, "exit\n")){ my_exit(0); }
        if (!strcmp(command, "history\n")){ history_command(history, command); }
        if (strcmp(command, "c"))
        {
            /* code */
        }
        

        // else { 
        //     intern_commands(command);
        // }
        
        // {
        //     // if (fork() != 0){
        //     //     //Pai
        //     //     waitpid(-1, &status, 0);
        //     // } else {
        //     //     execve(command, parameters, 0);
        //     // }
        // }
        
    } while (1);

    return 0;
}

void history_command(Queue history, char* command){
    int queue_size = size(history);

    for (int i = 0; i < queue_size; i++){
        char* temp_string;
        temp_string =  dequeue(history);
        enqueue(history, temp_string);
        printf("[%d]: %s\n", i+1, temp_string);
    }

    char* string = malloc(sizeof(char) * BUFFER_SIZE);
    char* nothing;
    read_command(string, nothing);
    string = strtok(string, "!");

    int index = atoi(string);

    for (int i = 0; i < queue_size; i++){   
        char* temp_string;
        temp_string =  dequeue(history);
        enqueue(history, temp_string);

        if (i == index-1)
            command = temp_string;
    }

    enqueue(history, command);
}

void type_prompt(){
    struct tm *time = get_time();
    printf("user@host[%02d:%02d:%02d]$ ", time->tm_hour, time->tm_min, time->tm_sec);
}

struct tm* get_time(){
    time_t segundos;
    time(&segundos);

    return localtime(&segundos);
}

void intern_commands(char command[]){
    printf("oi");
}


void read_command(char* command, char* parameters){
    fgets(command, BUFFER_SIZE, stdin);
    broke_string(command);
}

void broke_string(char* command){

}

void my_exit(int code) {
    asm (
        "movl $1, %%eax\n\t"
        "movl %[code], %%ebx\n\t"
        "int $0x80\n\t"
        : /* no output */
        : [code] "m" (code)
    );
}