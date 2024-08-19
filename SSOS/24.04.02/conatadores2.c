#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    
    int m;
    int n;

    scanf("%d", &n);
    scanf("%d", &m);

    int j = 0;
    int forks = m;
    for (int i = 0; i < forks; i++)
    {
        int pid = fork();

        if (pid == 0)
        {
            while (j < n/m)
            {
                printf("%d\n", j+1);
                j++;
            }
            
            exit(0);
        }

        waitpid(pid, NULL, 0);
    }
    
    return 0;
}
