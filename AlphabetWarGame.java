public class AlphabetWarGame
{
int s1=0;
int s2=0;
int w,p,b,s,m,q,d,z;
AlphabetWarGame()
{
}
AlphabetWarGame(int a,int r,int j,int o)
{
w=m=a;
p=q=r;
b=d=j;
s=z=o;
}
void AlphabetWar(String str)
{
for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='w')
{
s1=s1+4;
}
else if(str.charAt(i)=='p')
{
s1=s1+3;
}
else if(str.charAt(i)=='b')
{
s1=s1+2;
}
else if(str.charAt(i)=='s')
{
s1=s1+1;
}
else if(str.charAt(i)=='m')
{
s2=s2+4;
}
else if(str.charAt(i)=='q')
{
s2=s2+3;
}
else if(str.charAt(i)=='d')
{
s2=s2+2;
}
else if(str.charAt(i)=='z')
{
s2=s2+1;
}
else
{
System.out.println("Invalid character");
}
}
}
void AlphabetWar(String left, String right)
{
for(int i=0;i<left.length();i++)
{
if(left.charAt(i)=='w')
{
s1=s1+4;
}
else if(left.charAt(i)=='p')
{
s1=s1+3;
}
else if(left.charAt(i)=='b')
{
s1=s1+2;
}
else if(left.charAt(i)=='s')
{
s1=s1+1;
}
else
{
System.out.println("Invalid character");
}
}
for(int j=0;j<right.length();j++)
{
if(right.charAt(j)=='m')
{
s2=s2+4;
}
else if(right.charAt(j)=='q')
{
s2=s2+3;
}
else if(right.charAt(j)=='d')
{
s2=s2+2;
}
else if(right.charAt(j)=='z')
{
s2=s2+1;
}
else
{
System.out.println("Invalid character");
}
}
}
void Check()
{
if(s1>s2){
System.out.println("Left Wins");}
else if(s2>s1){
System.out.println("Right Wins");}
if(s1==s2){
System.out.println("Let's play again");
}
}
public static void main(String[] args)
{
AlphabetWarGame obj1= new AlphabetWarGame();
AlphabetWarGame obj2= new AlphabetWarGame(8,7,6,5);
obj1.AlphabetWar("zdqmwpbs");
obj1.Check();
obj2.AlphabetWar("z");
obj2.Check();
obj2.AlphabetWar("wwwwwwz");
obj2.Check();
}
}
