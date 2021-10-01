// This project works with clang only not with MinGW
// card.raw is the camera's memory card file
// card.raw file source is from Harvard's CS50x
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

typedef uint8_t BYTE;

int main(int argc, char *argv[])
{
    if (argc < 2) //Chceking Usage
    {
        printf("Usage: ./recover image \n");
        return 1;
    }

    FILE *card = fopen(argv[1], "r");

    if (card == NULL) //Checking the card
    {
        printf("Can't read the file, check again \n");
        return 2;
    }
    int count = 1;
    char *name = malloc(8);
    FILE *JPG = NULL;
    BYTE buffer[512]; //512Bytes at a time

    while (fread(buffer, 512, 1, card))
    {
        //Checking for JPG
        if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] & 0xf0) == 0xe0)
        {
            if (JPG == NULL) //For the first file
            {
                sprintf(name, "%03i.jpg", 0);
                JPG = fopen(name, "w");
                if (JPG == NULL)
                {
                    return 1;
                }
            }
            else
            {
                fclose(JPG);
                sprintf(name, "%03i.jpg", count);
                JPG = fopen(name, "w");
                ++count; //Increasing the count everytime after creating file
            }
            fwrite(buffer, 512, 1, JPG);
        }
        else if (JPG != NULL)
        {
            fwrite(buffer, 512, 1, JPG);
        }
    }

    free(name); //Freeing the memory
    fclose(JPG);
    fclose(card);
    return 0;
}
