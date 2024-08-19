#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int doFork(int start, int end, int fd[]);
double slowdown();

int main() {
    int fd[2];
    int sons, value;
    int start, end;
    int var;

    // printf("Digite o valor: ");
    // scanf("%d", &value);

    // printf("Digite o número de filhos: ");
    // scanf("%d", &sons);

    pipe(fd);

    sons = 8;
    value = 10000;


    for (int i = 0; i < sons; i++) {
        start = i * (value / sons) + 1;
        end = (i + 1) * (value / sons);

        doFork(start, end, fd);
    }

    if (value % sons != 0) {
        start = sons * (value / sons) + 1;
        end = value;

        doFork(start, end, fd);
    }

    close(fd[1]);

    int a = 0;
    for (int i = 0; i < sons; i++) {
        read(fd[0], &var, sizeof(var));
        a += var;
    }

    printf("%d\n", a);

    return 0;
}

int doFork(int start, int end, int fd[]) {
    if (!fork()) {
        close(fd[0]);

        int res = 0;
        for (int i = start; i < end + 1; i++) {
            res += i;
            slowdown();
        }

        write(fd[1], &res, sizeof(res));

        _exit(0);
    }
}

double slowdown() {
    double x = 0.001;
    for (int i = 0; i < 1000000; i++) {
        x = x + (i * x);
    }
    return x;
}