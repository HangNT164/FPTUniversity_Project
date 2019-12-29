//Assingment____ Quan__ly__Sach__

 /* SE1323_hangnt_he130461_Assignment 1*/
#include<stdio.h>
#include<stdlib.h>
#include <conio.h>
#include<math.h>
#include<string.h>
#include<ctype.h>

double value[100];
char bookName[100][50]={"Doremon","Pokemon","Conan","Tyquay"};
char bookCode[100][50]={"G12495","H15242","F15842","J45846"};
double price[100]={11.2,15.24,10.6,15.7};
int quantity[100]={100,542,900,700};
int size = 4,index; 
double sum=0.0;

	//bien cho function2-them sach
char s1[50],s2[50];
int a;
double b;

	// Ham thuc hien in Menu.
int enterMenu(){
   	printf("\n\t\t\t\tInformation of a Book \n\n");
	printf("1.Create default 4 books with their information .\n");
	printf("2.Add / Delete books.\n");
	printf("3.Search book by name.\n");
	printf("4.List all books.\n");
	printf("5.List all books after sorting by book name.\n");
	printf("6.Let user to choose some books to buy and compute the total price.\n");
	printf("7.Quit.\n");
	printf("8.New function.\n");
	//Chon chuc nang
	int function;
	printf("\nYou can function from 1 to 6:");
	scanf("%d",&function);
   	return function;
}

	//Ham Kiem Tra Book Code 
int test(char bookCode[]){
	int check=0;
	int isDigit = isdigit(bookCode[1])&& isdigit(bookCode[2]) && isdigit(bookCode[3]) && isdigit(bookCode[4]) && isdigit(bookCode[5]);
    if ( strlen(bookCode) == 6 && isupper(bookCode[0]) && isDigit){
    	check=1;
	}
	return check;
}
	//Ham chuc Nang 1 - hien thi thong tin sach
void informationBooks(){
	for(int i=0;i<size;i++){
		fflush(stdin);
		printf("\n\tBook Name %d:%s\n",i+1,bookName[i]);
		fflush(stdin);
		printf("\tBook Code %d:%s\n",i+1,bookCode[i]);
		fflush(stdin);
		printf("\tPrice %d : %lf \n",i+1,price[i]);
		printf("\tQuantity %d:%d\n",i+1,quantity[i]);
		printf("\n");
	}
}
		//Ham thuc hien fuction 2
//ham xoa vi tri bat ki
void deleteOneElement(){
	for(int i=index;i<size;i++){
		strcpy(bookName[i] , bookName[i+1]);
		strcpy(bookCode[i] , bookCode[i+1]);
		quantity[i]=quantity[i+1];
		price[i]=price[i+1];
	}
	size--;
}
		//Ham them
void addBook(){
	for(int i = size; i >=index; i --){
		strcpy(bookName[i] , bookName[i-1]);
		strcpy(bookCode[i] , bookCode[i-1]);
		quantity[i] = quantity[i-1];
     	price[i] = price[i-1];
    }
    strcpy(bookName[index] , s1);
	strcpy(bookCode[index] , s2);
   	quantity[index] = a;
   	price[index] = b;
   	size++;
}
	//Ham thuc hien function 3

//Ham nhap sach moi cua function3
void enterNewBook(){
	do{
		fflush(stdin);
		printf("New book name :");
		scanf("%[^\n]",&s1);
		fflush(stdin);	
	}
	while (strlen(s1)>50);
	do{
		fflush(stdin);
		printf("New book code  :");
		scanf("%[^\n]",&s2);
		fflush(stdin);
	}
	while (test(s2)==0);
	do{
		fflush(stdin);
		printf("New price:$");
		scanf("%lf",&b);
	}
	while (b>=1000);
	do{
		printf("New quantity :");
		scanf("%d",&a);
	}	
	while (a>=1000);
}
	//Ham tim ten sach - fuction 3
int findBook(char search[]) { 
	int i = 0, rc = -1;
	for (i = 0; i < size && rc == -1; i++){
		if (strcmp(search,bookName[i]) == 0){
			rc = i;
		}
	}
	return rc;
}

	//ham in sach  - function 4
void displayBooks(){
	printf("\n-----------------\n");
	printf("List all Book\n");
	printf("-------------------\n");
	printf("\tBookName     Book Code                  Price        Quantity\n");
	for (int i=0; i<size; i++){
	    printf("\t%-14s %-25s  %lf   %-8d \n ",bookName[i], bookCode[i], price[i], quantity[i]);
	}
}
	//Ham sap xep -fuction 5
void swapString(char a[], char b[]) {
    char temp[40] = "";
    strcpy(temp, a);
    strcpy(a, "");
    strcpy(a,b);
    strcpy(b, "");
    strcpy(b, temp);
}
void swap1(int &a,int &b){
	int temp=b;
	b=a;
	a=temp;
}
void swap2(double &a,double &b){
	double temp=b;
	b=a;
	a=temp;
}
void bubbleSortBookName(){
     int i, j;
     char temp[50];
     for (i = size - 1; i > 0; i--) {
         for (j = 0; j < i; j++) {
            if(strcmp(bookName[j],bookName[j+1]) > 0 ) {
				swapString(bookName[j], bookName[j+1]);
				swapString(bookCode[j], bookCode[j+1]);
				swap2(price[j], price[j+1]);
				swap1(quantity[j], quantity[j+1]);
            }
        }
    }
}
void display(){
	for(int i=0;i<size;i++){
		printf("%s  ",bookName[i]);
	}
	printf("\n");
}

	//Ham cho nguoi dung nhap vao function 6
int findPrice(char search[]) { 
	int i = 0;
	double price1=0;
	for (i = 0; i < size ; i++){
		if (strcmp(search,bookName[i]) == 0){
			price1=price[i];
		}
	}
	return price1;
}
char getChar(){
	int keeptrying=1;
	char kitu,rc,after;
	while(keeptrying==1){
		printf("\nYou want to buy book <y/n>:");
		rc=scanf("%c%c",&kitu,&after);
		if(kitu!='y'&& kitu!='n'||after!='\n'){
			printf("Your enter is wrong.\n");
			fflush(stdin);
		}
		else{
			keeptrying=0;
		}
	}
	return kitu;
}
void sumOfUser(){
	int afterQuantity[100];
	char kt;
	char book[100][50];
	double afterPrice[100];
	int  count =0;
	for(int j=0;1;j++){
		fflush(stdin);
		kt=getChar();
		fflush(stdin);
		if(kt=='y'){
			fflush(stdin);
			printf("\nEnter book you want to buy:");
			scanf("%s",&book[j]);
			fflush(stdin);
			int index1=findBook(book[j]);
			if(index1!=-1){
				afterPrice[j]=findPrice(book[j]);
				printf("\nEnter quantity of book %s you want to buy:",book[j]);
				scanf("%d",&afterQuantity[j]);
				count++;
			}
			else {
				printf("\nYour book doesn't  exist .\n");
			}
		}
		else if(kt=='n'){
			break;
		}
	}
	for(int j=0;j<count;j++){
		value[j]= afterQuantity[j]*afterPrice[j];
		sum+=value[j];
		quantity[j]=quantity[j]-afterQuantity[j];
	}
	printf(" Book Name   Quantity Buy   Price   Value\n");
	for (int j=0; j<count; j++){
	       printf("%s           %d            %lf       %lf\n",book[j],afterQuantity[j],afterPrice[j],value[j]);
    }
    printf("-----------------------------------------------------");
	printf("\n					     Total=%lf",sum);
}
int main(){
    int chon;
   	do{
	    chon = enterMenu();
	    switch (chon){
	        case 1:{
	        	informationBooks();
				break;
			}
		    case 2:{
	        	int x;
	        	printf("\nYou want to delete or add books.\n");
				printf("\n\tIf you choose one.Program will help you choose add books.\n");
				printf("\n\tIf you choose zero.Program will help you choose delete a book.\n");
				fflush(stdin);
				do{
					printf("\nYou choose 1 or 0:");
					scanf("%d",&x);
				}
				while (x>=2);
				if(x==0){
					int a;
					char s1[100];
					fflush(stdin);
					printf("\nEnter book you want to delete :");
					scanf("%[^\n]",s1);
					fflush(stdin);
						index=findBook(s1);
						int z;
						z=index+1;
					if(index>=0){
						deleteOneElement();
						printf("\nAfter delete book %s in index %d:\n",s1,z);
						displayBooks();
					}
					else{
						printf("\nYour book is wrong and you can't delete it '.\n");
						break;
					}
				}
				if(x==1){
					printf("\n\tYou can enter many books if you want.\n");
					printf("\n\tIf you want to stop , you can enter an non-negative numbers at index.\n ");
					int j=1;
					while (1){
						printf("\n\tInformation of extra book %d:\n",j);
						int b;
						printf("\nEnter index you want to add:");
						scanf("%d",&b);
						index=b-1;
						if(b>=1){
							enterNewBook();
							addBook();
							j++;
							printf("\n");
						}
						if(b <1){
							break;
						}
					}
					printf("\nAfter add:\n");
					displayBooks();
				}
					break;
			}
	        case 3:{
        		char name[50];
        		fflush(stdin);
				printf("\nEnter book you want to find:");
				scanf("%[^\n]",name);
				fflush(stdin);
				int check=findBook(name);
				if(check!=-1){
					int check1=check+1;
					printf("\nIndex of book %s is %d\n",name,check1);
					printf("\nBook code of %s is %s\n",name,bookCode[check]);
					printf("\nPrice of  %s is %lf\n",name,price[check]);
					printf("\nQuantity of %s is %d\n",name,quantity[check]);
				}
				else {
					printf("\nCan not find the location of %s\n",name);
				}
				break;
			}
	        case 4:{
	        	displayBooks();
				break;
			}
	        case 5:{
	        	bubbleSortBookName();
	        	printf("\t\tAfter softing by book name:");
	        	display();
				displayBooks();
				break;
			}
			case 6:{
	        	sumOfUser();
				break;
			}
			case 7:{
				break;
			}
			default:{
				printf("\nYour function is wrong.\n");
				break;
			}
	      }
	}
	while (chon!=7);
	return 0;
}


