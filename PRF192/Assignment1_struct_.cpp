/*
	Assignment 1  -BookList
	Class  ID :SE1323
	Student ID:HE130461
	Student Name :Nguyen Thuy Hang
	I declare that this assignment is my own work.
*/

#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
#include<ctype.h>
double value[100];
int size = 4,index; 
double sum=0.0;

	//bien cho function2-them sach
char s1[50],s2[50];
int a;
double d;

//
struct books{
	char bookName[50];
	char bookCode[50];
	double price;
	int quantity;
};

//
	struct books b[100];

	// Ham thuc hien in Menu.
int enterMenu(){
   	printf("\n\t\t\t Information of a Book \n\n");
	printf("1.Create default 4 books with their information .\n");
	printf("2.Add / Delete books.\n");
	printf("3.Search book by name.\n");
	printf("4.List all books.\n");
	printf("5.List all books after sorting by book name.\n");
	printf("6.Let user to choose some books to buy and compute the total price.\n");
	printf("7.Quit.\n");
	//Chon chuc nang
	int function;
	printf("You can function from 1 to 6:");
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
		printf("\nInformation of book %d:\n",i+1);
		do{
			fflush(stdin);
			printf("\nEnter book Name:");
			gets(b[i].bookName);
		}
		while (strlen(b[i].bookName)>=50);
		do{
			fflush(stdin);
			printf("\nEnter book Code : ");
			gets(b[i].bookCode);
		}
		while (test(b[i].bookCode)==0);
		fflush(stdin);
		do{
			printf("\nEnter price :$ ");
			scanf("%lf",&b[i].price);
		}
		while (b[i].price>=1000);
		do{
			printf("\nEnter quantity: ");
			scanf("%d",&b[i].quantity);	
		}
		while (b[i].quantity>=1000);	
	}
	printf("\n\n");
}
	//Ham thuc hien fuction 2
//ham xoa vi tri bat ki
void deleteOneElement(){
	for(int i=index;i<size-1;i++){
		strcpy(b[i].bookName , b[i+1].bookName);
		strcpy(b[i].bookCode , b[i+1].bookCode);
		b[i].quantity =b[i+1].quantity;
		b[i].price =b[i+1].price;
	}
	size--;
}
//Ham them
void addBook(){
	for(int i = size; i >=index; i --){
		strcpy(b[i].bookName , b[i-1].bookName);
		strcpy(b[i].bookCode , b[i-1].bookCode);
		b[i].quantity =b[i-1].quantity;
		b[i].price =b[i-1].price;
    }
	strcpy(b[index].bookName , s1);
	strcpy(b[index].bookCode , s2);
	b[index].quantity =a;
	b[index].price =d;
   	size++;
}
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
		scanf("%lf",&d);
	}
	while (d>=1000);
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
		if (strcmp(search,b[i].bookName) == 0){
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
	printf("BookName     Book Code                  Price        Quantity\n");
	for (int i=0; i<size; i++){
	    printf("%-14s %-25s  %lf   %-8d \n  ",b[i].bookName, b[i].bookCode, b[i].price, b[i].quantity);
	}
}
	//Ham thuc hien function 4
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
void bubbleSortBookName() {
     int i, j;
     char temp[50];
     for (i = size - 1; i > 0; i--) {
         for (j = 0; j < i; j++) {
            if(strcmp(b[j].bookName,b[j+1].bookName) > 0 ) {
				swapString(b[j].bookName,b[j+1].bookName);
				swapString(b[j].bookCode,b[j+1].bookCode);
				swap2(b[j].price,b[j+1].price);
				swap1(b[j].quantity,b[j+1].quantity);

            }
        }
    }
}
void display(){
	for(int i=0;i<size;i++){
		printf("%s  ",b[i].bookName);
	}
	printf("\n");
}

	//Ham cho nguoi dung nhap vao function 6
void sumOfUser(){
	int a[100];
	char book[100][50];
		for(int i=0;i<size;i++){
			fflush(stdin);
			printf("Book %s ?:\n",b[i].bookName);
			fflush(stdin);
			printf("Enter number book user want to buy :");
			scanf("%d",&a[i]);
	}
	for(int i=0;i<size;i++){
		value[i]=b[i].price*a[i];
	sum+=value[i];
	}
	printf("Book Name     Book Code                  Price         Quantity          Quantity purchased       \n");
	for(int i=0;i<size;i++){
		printf("%s           %s             %lf            %d                %d\n",b[i].bookName,b[i].bookCode,b[i].price,b[i].quantity,a[i]);
	}
	printf("-----------------------------------------------------");
	printf("\n					     Total=%lf",sum);
}	
int main(){
	int chon;
	do{
		chon=enterMenu();
		switch(chon){
			case 1:{
				informationBooks();
				break;
			}
			case 2:{
				int x;
	        	printf("You want to delete or add books.\n");
				printf("\nIf you choose one.Program will help you choose add books.\n");
				printf("\nIf you choose zero.Program will help you choose delete book.\n");
				fflush(stdin);
				do{
					printf("You choose 1 or 0:");
					scanf("%d",&x);
				}
				while (x>=2);
				if(x==0){
					int a;
					char s1[100];
					fflush(stdin);
					printf("Enter book you want to delete :");
					scanf("%[^\n]",s1);
					fflush(stdin);
					index=findBook(s1);
					int z;
					z=index+1;
					if(index>=0){
						deleteOneElement();
						printf("After delete book %s in index %d:\n",s1,z);
						displayBooks();
					}
					else{
						printf("Your book is wrong and you can't delete it '.\n");
						break;
					}
				}
				if(x==1){
					int j=1;
					while (1){
						printf("Information of extra book %d:\n",j);
						int h;
						printf("Enter index you want to add:");
						scanf("%d",&h);
						index=h-1;
						if(h>=1){
							enterNewBook();
							addBook();
							j++;
							printf("\n");
						}
						if(h <1){
							break;
						}
					}
					printf("After add:\n");
					displayBooks();
				}
					break;
			}
	        case 3:{
        		char name[50];
        		fflush(stdin);
				printf("Enter book you want to find:");
				scanf("%[^\n]",name);
				fflush(stdin);
				int check=findBook(name);
				int check1=check+1;
				printf("Index of book %s is %d:",name,check1);
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
				printf("Your function is wrong.\n");
				break;
			}
	      }
	}
	while (chon!=7);
	return 0;
}


