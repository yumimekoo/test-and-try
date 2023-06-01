int [] sort(int[] a){
int c = 0;
int d = 0;
int counter = 1;
boolean flag = false;
int [] sum = a;
while(flag==false){
    for (int i = 0; i < (a.length)-1;i++){
        c = sum[i+1];
        d = sum[i];
        if(d>c){
            sum[i] = c; 
            sum [i+1] = d;
            flag = false;
        } else {
            sum[i] = d;
            counter++;
        }
        if(counter==a.length-1){
            flag=true;
        } 
    }
    // print(sum);
    counter = 0;   
}
return sum; 
}

// visual purposes only //
void print(int [] a){
    for (int i = 0; i < a.length;i++){
        if (i != a.length-1){
        System.out.print(a[i]+", ");
        } else {
        System.out.print(a[i]);
        System.out.println();
        } 
    }
}
