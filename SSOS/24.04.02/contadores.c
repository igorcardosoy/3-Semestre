#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    int pid1 = fork();
    if (pid1 == 0)
    {
        for (int i = 1; i <= 50; i++)
        {
            printf("%d\n", i);
        }
        exit(0);
        
    }

    int pid2 = fork();
    if (pid2 == 0)
    {
        for (int i = 51; i <= 100; i++)
        {
            printf("%d\n", i);
        }
        exit(0);
        
    }

    waitpid(0, &pid1, 0);
    
    waitpid(0, &pid2, 0);

    return 0;
}
