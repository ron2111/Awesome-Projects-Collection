#include <stdio.h>
#include <string.h>
int main(){
    char data[100000];
    char num[]="1234567890";
    char uprletters[]="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char lwrletters[]="abcdefghijklmnopqrstuvwxyz";
    printf("Enter the text to be analysed : ");
    scanf("%[^\n]",data);
    int numbers=0,lwr=0,upr=0,words=0;
  
    for(int i=0;i<strlen(data);i++){
        for(int j=0;j<strlen(num);j++){
            if(data[i] == num[j]){
                numbers++;
            }
        }
        for(int j=0;j<strlen(uprletters);j++){
            if(data[i] == uprletters[j]){
                upr++;
            }
        }
        for(int j=0;j<strlen(lwrletters);j++){
            if(data[i] == lwrletters[j]){
                lwr++;
            }
        }
    }
    // for number of words
    char blank = ' ';
    for(int j=0;j<strlen(data);j++){
        if(data[j + 1] == blank){
            words++;
        }
        if(j == strlen(data) - 1){
            words++;
        }
    }
    printf("ANALYSIS : \n");
    printf("Total Numbers in the text are : %d\n",numbers);
    printf("Total Upper cases in the text are : %d\n",upr);
    printf("Total lower cases in the text are : %d\n",lwr);
    printf("Total Words in the text are : %d\n",words);
    char special;
    int choice,s=0;
    printf("Any specific character you want to analyse in this text ? Press 1 for Yes or any other key for No\n");
    scanf("%d",&choice);
    if(choice == 1){
        printf("Enter the character you want to analyse : ");
        scanf(" %c",&special);
        for(int i=0;i<strlen(data);i++){
            if(data[i] == special){
                s++;
            }
        }
        printf("Total %c in the text are : %d\n",special,s);
    }
    else{
        printf("******Press ENTER to exit******\n");
    }
    getchar();
     getchar();
    return 0;
}
