import java.nio.channels.spi.SelectorProvider;
import java.util.Scanner;

class Ship {
    private int [] shipP1 = new int[80];
    private int [] shipP2 = new int[80];
    private String [] shotP1 = new String[80];
    private String [] shotP2 = new String[80];
    private boolean winP1 = false;
    private boolean winP2 = false;
    private String namep1 = " ";
    private String namep2 = " ";
    Scanner scanner = new Scanner(System.in);

    private void initStart(){
        for (int i = 0; i<80; i++){
            this.shotP1[i] = "[ ]";
            this.shotP2[i] = "[ ]";
        }
    }

    private int calc (String s){
        if(s.length()>1){
            String l = s.toLowerCase();
            char a = l.charAt(0);
            char b = l.charAt(1);
            int result = (((a*100)+b*10)-10190)/10;
            return result;
        }
        return -1;
    }

    private void typeWriter(String s){
            for(int i = 0; i<s.length();i++){
                System.out.print(s.charAt(i));
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println();
    }

    private void printWelcome(){
        String s = "Welcome to Offensive-Battleships by Yumimeko (aka. Anton)";
        String t = "(i really mean offensive offensive)";
        String u = "are you too stunned to speak? come.";
        String v = "play.";
        String w = "GO MAN!";
        
        typeWriter(s);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeWriter(t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeWriter(u);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeWriter(v);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        typeWriter(w);
        
    }


    private String randomResponse (int y){
        if (y==1){  
            double x = Math.random();
            if(x<0.1 && x>0){
                return this.namep1+" ... interesting";
            }
            if(x<0.2 && x>0.1){
                return this.namep1+", thats cool. i guess...";
            }
            if(x<0.3 && x>0.2){
                return this.namep1+"? you're joking right? ";
            }
            if(x<0.4 && x>0.3){
                return this.namep1+" .. come on, you can do better.";
            }
            if(x<0.5 && x>0.4){
                return "uhmm .. "+this.namep1+" , you better be joking.";
            }   
            if(x<0.6 && x>0.5){
                return "oh cooool, "+this.namep1+" how edgy, you're soooo different ..";
            }
            if(x<0.7 && x>0.6){
                return "that sounds like a trashcan '"+this.namep1+"' haha." ;
            }
            if(x<0.8 && x>0.7){
                return "Oh, "+this.namep1+ " Nice!  ... are you finally starting to get creative? ";
            }
            if(x<0.9 && x>0.8){
                return this.namep1+"... sometimes ... i want to intentionally catch a virus ...";
            }
            else{
                return this.namep1+" lame.";
            }
        }
        if (y==2){
            double x = Math.random();
            if(x<0.1 && x>0){
                return this.namep2+" ... interesting";
            }
            if(x<0.2 && x>0.1){
                return this.namep2+", thats cool. i guess...";
            }
            if(x<0.3 && x>0.2){
                return this.namep2+"? you're joking right? ";
            }
            if(x<0.4 && x>0.3){
                return this.namep2+" .. come on, you can do better.";
            }
            if(x<0.5 && x>0.4){
                return "i mean .. "+this.namep2+" , you better be joking.";
            }   
            if(x<0.6 && x>0.5){
                return "oh cooool, "+this.namep2+" how edgy, you're soooo different ..";
            }
            if(x<0.7 && x>0.6){
                return "that sounds like a trashcan '"+this.namep2+"' haha." ;
            }
            if(x<0.8 && x>0.7){
                return "Oh, "+this.namep2+ " Nice!  ... are you finally starting to get creative? ";
            }
            if(x<0.9 && x>0.8){
                return this.namep2+"... sometimes ... i want to intentionally catch a virus ...";
            }
            else{
                return this.namep2+" lame.";
            }
        }
    return "if this happens, then congrats, anton is stupid";
    }

    private void nameGiveP1(){
        typeWriter("Player 1, can you finally choose your name? ");
        this.namep1=scanner.nextLine();
        System.out.println();
        typeWriter(randomResponse(1));
        System.out.println();
        System.out.println();
    }

    private void nameGivep2(){
        typeWriter("Player 2, give me your name, hurry up.. ");
        this.namep2=scanner.nextLine();
        System.out.println();
        typeWriter(randomResponse(2));
        System.out.println();
        System.out.println();
    }

    public void play() throws InterruptedException{
        for(int i = 0; i<70; i++){
            System.out.println();
        }
        printWelcome();
        System.out.println();
        initStart();
        nameGiveP1();
        nameGivep2();
        typeWriter(this.namep1+" hide your ships! (and don't be stupid like "+namep2+" and make that obvious)");
        System.out.println();
        placeShipP1();
        for(int i = 0; i<70; i++){
            System.out.println();
        }
        typeWriter(this.namep2+" hide your ships! (the same applies to you.. dont be like "+namep1+")");
        System.out.println();
        placeShipP2();
        for(int i = 0; i<70; i++){
            System.out.println();
        }
        startGame();
    }

    private void startGame(){
        int i = 2; 
        int counterP1 = 0;
        int counterP2 = 0;
        while (true){
            if(i%2==0){
                typeWriter(this.namep1+"'s turn: ");
                String kys = scanner.next();
                String k = kys.toLowerCase();
                int s = calc(k);
                if ((s>=0 && s<8)||(s>=10 && s<18) || (s>=20 && s<28) || (s>=30 && s<38) || (s>= 40 && s<48) || (s>= 50 && s<58) || (s>= 60 && s<68) || (s>= 70 && s<78) && k.length()==2){
                    if(isShottedP1(s)==false){
                        if (this.shipP2[s]==0){
                            this.shotP1[s] = "[0]";
                            printGrids();
                            typeWriter(this.namep1+" Missed.");
                            System.out.println();
                            i++;
                        }
                        if (this.shipP2[s]==2 || this.shipP2[s]==3 || this.shipP2[s]==4 || this.shipP2[s]==5 ){
                            this.shotP1[s] = "[X]";
                            printGrids();
                            typeWriter(this.namep1+" Hit that shit, shoot again!");
                            System.out.println();
                            counterP1++;
                            if(counterP1==14){
                                this.winP1=true;
                                break;
                            }
                            i=i+2;
                        }
                    } else {
                        i = i+2;
                    }            
                }  else {
                    typeWriter("No valid shot. Don't be stupid, try in a field between A1 and H8");
                    System.out.println();
                    i = i+2;
                }
            }
            if(i%2==1){
                typeWriter(this.namep2+"'s turn: ");
                String kk = scanner.next();
                String x = kk.toLowerCase();
                int s = calc(x);
                if ((s>=0 && s<8)||(s>=10 && s<18) || (s>=20 && s<28) || (s>=30 && s<38) || (s>= 40 && s<48) || (s>= 50 && s<58) || (s>= 60 && s<68) || (s>= 70 && s<78) && x.length()==2){
                if(isShottedP2(s)==false){
                    if (this.shipP1[s]==0){
                        this.shotP2[s] = "[0]";
                        printGrids();
                        typeWriter(this.namep2+" Missed.");
                        System.out.println();
                        i++;
                    }
                    if (this.shipP1[s]==2 || this.shipP1[s]==3 || this.shipP1[s]==4 || this.shipP1[s]==5 ){
                        this.shotP2[s] = "[X]";
                        printGrids();
                        typeWriter(this.namep2+" Hit that shit, shoot again!");
                        System.out.println();
                        counterP2++;
                        if(counterP2==14){
                            this.winP2=true;
                            break;
                        }
                        i=i+2;
                    }
                } else {
                    i = i+2;
                }
            } else {
                typeWriter("No valid shot. Don't be stupid, try in a field between A1 and H8");
                System.out.println();
                i = i+2;
            }
        }

        }
        if(winP1==true){
            boom();
            typeWriter(this.namep1+" won and destroyed INDIA .. oh no wait *cough* i mean he destroyed "+this.namep2);
        }
        if(winP2==true){
            boom();
            typeWriter(this.namep2+" won and destroyed INDIA .. oh no wait *cough* i mean he destroyed "+this.namep1);
        }
    }

    private boolean isShottedP1(int s){
        String x = this.shotP1[s];
        if (x.equals("[X]") || x.equals("[0]")){
            return true;
        } else {
            return false;
        }
    }
    private boolean isShottedP2(int s){
        String x = this.shotP2[s];
        if (x.equals("[X]") || x.equals("[0]")){
            return true;
        } else {
            return false;
        }
    }

    public void printGrids(){
        System.out.println("     ----- "+namep1+" -----               ----- "+namep2+" -----");
        System.out.println("    A  B  C  D  E  F  G  H           A  B  C  D  E  F  G  H");
        System.out.println("1 |"+shotP1[0]+shotP1[10]+shotP1[20]+shotP1[30]+shotP1[40]+shotP1[50]+shotP1[60]+shotP1[70]+"    |    "+shotP2[0]+shotP2[10]+shotP2[20]+shotP2[30]+shotP2[40]+shotP2[50]+shotP2[60]+shotP2[70]+"| 1");
        System.out.println("2 |"+shotP1[1]+shotP1[11]+shotP1[21]+shotP1[31]+shotP1[41]+shotP1[51]+shotP1[61]+shotP1[71]+"    |    "+shotP2[1]+shotP2[11]+shotP2[21]+shotP2[31]+shotP2[41]+shotP2[51]+shotP2[61]+shotP2[71]+"| 2");
        System.out.println("3 |"+shotP1[2]+shotP1[12]+shotP1[22]+shotP1[32]+shotP1[42]+shotP1[52]+shotP1[62]+shotP1[72]+"    |    "+shotP2[2]+shotP2[12]+shotP2[22]+shotP2[32]+shotP2[42]+shotP2[52]+shotP2[62]+shotP2[72]+"| 3");
        System.out.println("4 |"+shotP1[3]+shotP1[13]+shotP1[23]+shotP1[33]+shotP1[43]+shotP1[53]+shotP1[63]+shotP1[73]+"    |    "+shotP2[3]+shotP2[13]+shotP2[23]+shotP2[33]+shotP2[43]+shotP2[53]+shotP2[63]+shotP2[73]+"| 4");
        System.out.println("5 |"+shotP1[4]+shotP1[14]+shotP1[24]+shotP1[34]+shotP1[44]+shotP1[54]+shotP1[64]+shotP1[74]+"    |    "+shotP2[4]+shotP2[14]+shotP2[24]+shotP2[34]+shotP2[44]+shotP2[54]+shotP2[64]+shotP2[74]+"| 5");
        System.out.println("6 |"+shotP1[5]+shotP1[15]+shotP1[25]+shotP1[35]+shotP1[45]+shotP1[55]+shotP1[65]+shotP1[75]+"    |    "+shotP2[5]+shotP2[15]+shotP2[25]+shotP2[35]+shotP2[45]+shotP2[55]+shotP2[65]+shotP2[75]+"| 6");
        System.out.println("7 |"+shotP1[6]+shotP1[16]+shotP1[26]+shotP1[36]+shotP1[46]+shotP1[56]+shotP1[66]+shotP1[76]+"    |    "+shotP2[6]+shotP2[16]+shotP2[26]+shotP2[36]+shotP2[46]+shotP2[56]+shotP2[66]+shotP2[76]+"| 7");
        System.out.println("8 |"+shotP1[7]+shotP1[17]+shotP1[27]+shotP1[37]+shotP1[47]+shotP1[57]+shotP1[67]+shotP1[77]+"    |    "+shotP2[7]+shotP2[17]+shotP2[27]+shotP2[37]+shotP2[47]+shotP2[57]+shotP2[67]+shotP2[77]+"| 8");
    }
    private void boom(){
        System.out.println("                               ________________        ");
        System.out.println("                          ____/ (  (    )   )   ___");
        System.out.println("                         /( (  (  )   _    ))  )   ) ");
        System.out.println("                       ((     (   )(    )  )   (   )  )");
        System.out.println("                     ((/  ( _(   )   (   _) ) (  () )  )");
        System.out.println("                    ( (  ( (_)   ((    (   )  .((_ ) .  )_");
        System.out.println("                   ( (  )    (      (  )    )   ) . ) (   )");
        System.out.println("                  (  (   (  (   ) (  _  ( _) ).  ) . ) ) ( )");
        System.out.println("                  ( (  (   ) (  )   (  ))     ) _)(   )  )  )");
        System.out.println("                 ( (  (   ) (    (_  ( ) ( )  )   ) )  )) ( )");
        System.out.println("                  (  (   (  (   (_ ( ) ( _    )  ) (  )  )   )");
        System.out.println("                 ( (  ( (  (  )     (_  )  ) )  _)   ) _( ( )");
        System.out.println("                  ((  (   )(    (     _    )   _) _(_ (  (_ )");
        System.out.println("                   (_((__(_(__(( ( ( |  ) ) ) )_))__))_)___)");
        System.out.println("                   ((__)          ||lll|l||///           _))");
        System.out.println("                            (   /(/ (  )  ) )    )");
        System.out.println("                          (    ( ( ( | | ) ) )    )");
        System.out.println("                           (   /(| / ( )) ) ) )) ) ");
        System.out.println("                         (     ( ((((_(|)_)))))     )");
        System.out.println("                          (      || (|(|)|/||     )");
        System.out.println("                        (        |(||(||)||||        ) ");
        System.out.println("                          (     //|/l|||)|  |      )");
        System.out.println("                        (/ / //  /|//||||   L_      _)");
    }
    private void placeShipP1(){
        for (int n = 2; n<6; n++){
            shipPlacementP1();
            System.out.println();
            boolean intEx = true;
            while(intEx==true){
                typeWriter("Place the head of the ship: (Length:"+n+")");
                String c = scanner.next();
                int p = calc(c);
                if (c.charAt(0)>96 && c.charAt(0)<105 && c.charAt(1)>48 && c.charAt(1)<57 && this.shipP1[p]==0 && c.length()==2){
                    boolean dirEx = true;
                    int counterFalseMove = 0;
                    while (dirEx==true){
                        if (counterFalseMove==4){
                            dirEx = false;
                        }
                        System.out.println();
                        typeWriter("Choose direction. Options: N,E,S,W");
                        String yy = scanner.next();
                        String y = yy.toLowerCase();
                        if(y.equals("n")|| y.equals("s")||y.equals("w")||y.equals("e")){
                            if (y.equals("n")){    
                                if (c.charAt(1)-49>=n-1 && shipBlockedP1N(n, p)==false){
                                    int pn = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP1[pn]=n;
                                        pn=pn-1;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;

                                }
                            }
                            if(y.equals("s")){
                                if ((c.charAt(1)-49)-1+n<8 && shipBlockedP1S(n,p)==false){
                                    int ps = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP1[ps]=n;
                                        ps=ps+1;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;

                                }
                            }
                            if(y.equals("e")){
                                if (c.charAt(0)-97+n-1<8 && shipBlockedP1O(n, p)==false){
                                    int pp = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP1[pp]=n;
                                        pp=pp+10;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;

                                }
                            }
                            if(y.equals("w")){
                                if (c.charAt(0)-97>=n-1 &&shipBlockedP1W(n, p)==false){
                                    int pp = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP1[pp]=n;
                                        pp=pp-10;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;
                                }
                            }
    
                        } else {
                            typeWriter("Enter one of the four options.");
                        }
                    }
                } else {
                    typeWriter("Don't be stupid, try in a field between A1 and H8 (Or its just blocked and u are blind aswell)");
                }
            }
        }
    }
    private void placeShipP2(){
        for (int n = 2; n<6; n++){
            shipPlacementP2();
            System.out.println();
            boolean intEx = true;
            while(intEx==true){
                typeWriter("Place the head of the ship: (Length:"+n+")");
                String c = scanner.next();
                int p = calc(c);
                int counterFalseMove = 0;
                if (c.charAt(0)>96 && c.charAt(0)<105 && c.charAt(1)>48 && c.charAt(1)<57 && this.shipP2[p]==0){
                    boolean dirEx = true;
                    while (dirEx==true){
                        if (counterFalseMove==4){
                            dirEx = false;
                        }
                        System.out.println();
                        typeWriter("Choose direction. Options: N,E,S,W");
                        String yy = scanner.next();
                        String y = yy.toLowerCase();
                        if(y.equals("n")|| y.equals("s")||y.equals("w")||y.equals("e")){
                            if (y.equals("n")){    
                                if (c.charAt(1)-49>=n-1 && shipBlockedP2N(n, p)==false){
                                    int pn = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP2[pn]=n;
                                        pn=pn-1;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;
                                    System.out.println(counterFalseMove);
                                }
                            }
                            if(y.equals("s")){
                                if ((c.charAt(1)-49)-1+n<8 && shipBlockedP2S(n, p)==false){
                                    int ps = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP2[ps]=n;
                                        ps=ps+1;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;
                                    System.out.println(counterFalseMove);

                                }
                            }
                            if(y.equals("e")){
                                if (c.charAt(0)-97+n-1<8 && shipBlockedP2O(n, p)==false){
                                    int pp = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP2[pp]=n;
                                        pp=pp+10;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;
                                    System.out.println(counterFalseMove);

                                }
                            }
                            if(y.equals("w")){
                                if (c.charAt(0)-97>=n-1 && shipBlockedP2W(n, p)==false){
                                    int pp = p;
                                    dirEx = false;
                                    intEx = false;
                                    for(int i = 0; i<n; i++){
                                        shipP2[pp]=n;
                                        pp=pp-10;
                                    }
                                } else {
                                    typeWriter("Its Blocked or not Valid!");
                                    counterFalseMove++;
                                    System.out.println(counterFalseMove);

                                }
                            }
    
                        } else {
                            typeWriter("Enter one of the four options.");
                        }
                    }
                } else {
                    typeWriter("Don't be stupid, try in a field between A1 and H8 (Or its just blocked and u are blind aswell)");
                }
            }
        }
    }

    private boolean shipBlockedP1S(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP1[pp]!=0){
                    return true;
                }
            }
            pp = pp+1;
        }
        return false;
        
    }
    private boolean shipBlockedP1N(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP1[pp]!=0){
                    return true;
                }
            }
            pp = pp-1;
        }
        return false;
        
    }
    private boolean shipBlockedP1W(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP1[pp]!=0){
                    return true;
                }
            }
            pp = pp-10;
        }
        return false;
        
    }
    private boolean shipBlockedP1O(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP1[pp]!=0){
                    return true;
                }
            }
            pp = pp+10;
        }
        return false;
        
    }

    private boolean shipBlockedP2S(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP2[pp]!=0){
                    return true;
                }
            }
            pp = pp+1;
        }
        return false;
        
    }
    private boolean shipBlockedP2N(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP2[pp]!=0){
                    return true;
                }
            }
            pp = pp-1;
        }
        return false;
        
    }
    private boolean shipBlockedP2W(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP2[pp]!=0){
                    return true;
                }
            }
            pp = pp-10;
        }
        return false;
        
    }
    private boolean shipBlockedP2O(int n, int p){
        int pp = p;
        for (int i = 0; i<n; i++){
            
            if(pp<0 || pp>77){
                return true; 
            } else {
                if (shipP2[pp]!=0){
                    return true;
                }
            }
            pp = pp+10;
        }
        return false;
        
    }

    private void shipPlacementP1(){
        System.out.println("    A  B  C  D  E  F  G  H");
        System.out.println("1 |"+"["+shipP1[0]+"]["+shipP1[10]+"]["+shipP1[20]+"]["+shipP1[30]+"]["+shipP1[40]+"]["+shipP1[50]+"]["+shipP1[60]+"]["+shipP1[70]+"]");
        System.out.println("2 |"+"["+shipP1[1]+"]["+shipP1[11]+"]["+shipP1[21]+"]["+shipP1[31]+"]["+shipP1[41]+"]["+shipP1[51]+"]["+shipP1[61]+"]["+shipP1[71]+"]");
        System.out.println("3 |"+"["+shipP1[2]+"]["+shipP1[12]+"]["+shipP1[22]+"]["+shipP1[32]+"]["+shipP1[42]+"]["+shipP1[52]+"]["+shipP1[62]+"]["+shipP1[72]+"]");
        System.out.println("4 |"+"["+shipP1[3]+"]["+shipP1[13]+"]["+shipP1[23]+"]["+shipP1[33]+"]["+shipP1[43]+"]["+shipP1[53]+"]["+shipP1[63]+"]["+shipP1[73]+"]");
        System.out.println("5 |"+"["+shipP1[4]+"]["+shipP1[14]+"]["+shipP1[24]+"]["+shipP1[34]+"]["+shipP1[44]+"]["+shipP1[54]+"]["+shipP1[64]+"]["+shipP1[74]+"]");
        System.out.println("6 |"+"["+shipP1[5]+"]["+shipP1[15]+"]["+shipP1[25]+"]["+shipP1[35]+"]["+shipP1[45]+"]["+shipP1[55]+"]["+shipP1[65]+"]["+shipP1[75]+"]");
        System.out.println("7 |"+"["+shipP1[6]+"]["+shipP1[16]+"]["+shipP1[26]+"]["+shipP1[36]+"]["+shipP1[46]+"]["+shipP1[56]+"]["+shipP1[66]+"]["+shipP1[76]+"]");
        System.out.println("8 |"+"["+shipP1[7]+"]["+shipP1[17]+"]["+shipP1[27]+"]["+shipP1[37]+"]["+shipP1[47]+"]["+shipP1[57]+"]["+shipP1[67]+"]["+shipP1[77]+"]");

    }

    private void shipPlacementP2(){
        System.out.println("    A  B  C  D  E  F  G  H");
        System.out.println("1 |"+"["+shipP2[0]+"]["+shipP2[10]+"]["+shipP2[20]+"]["+shipP2[30]+"]["+shipP2[40]+"]["+shipP2[50]+"]["+shipP2[60]+"]["+shipP2[70]+"]");
        System.out.println("2 |"+"["+shipP2[1]+"]["+shipP2[11]+"]["+shipP2[21]+"]["+shipP2[31]+"]["+shipP2[41]+"]["+shipP2[51]+"]["+shipP2[61]+"]["+shipP2[71]+"]");
        System.out.println("3 |"+"["+shipP2[2]+"]["+shipP2[12]+"]["+shipP2[22]+"]["+shipP2[32]+"]["+shipP2[42]+"]["+shipP2[52]+"]["+shipP2[62]+"]["+shipP2[72]+"]");
        System.out.println("4 |"+"["+shipP2[3]+"]["+shipP2[13]+"]["+shipP2[23]+"]["+shipP2[33]+"]["+shipP2[43]+"]["+shipP2[53]+"]["+shipP2[63]+"]["+shipP2[73]+"]");
        System.out.println("5 |"+"["+shipP2[4]+"]["+shipP2[14]+"]["+shipP2[24]+"]["+shipP2[34]+"]["+shipP2[44]+"]["+shipP2[54]+"]["+shipP2[64]+"]["+shipP2[74]+"]");
        System.out.println("6 |"+"["+shipP2[5]+"]["+shipP2[15]+"]["+shipP2[25]+"]["+shipP2[35]+"]["+shipP2[45]+"]["+shipP2[55]+"]["+shipP2[65]+"]["+shipP2[75]+"]");
        System.out.println("7 |"+"["+shipP2[6]+"]["+shipP2[16]+"]["+shipP2[26]+"]["+shipP2[36]+"]["+shipP2[46]+"]["+shipP2[56]+"]["+shipP2[66]+"]["+shipP2[76]+"]");
        System.out.println("8 |"+"["+shipP2[7]+"]["+shipP2[17]+"]["+shipP2[27]+"]["+shipP2[37]+"]["+shipP2[47]+"]["+shipP2[57]+"]["+shipP2[67]+"]["+shipP2[77]+"]");
    }
}    
Ship a = new Ship();
a.play();







