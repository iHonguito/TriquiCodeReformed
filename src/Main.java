import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int eleccion = 0;
        Scanner in = new Scanner(System.in);
        //Menú de inicio
        while(eleccion != 3){
            Clear();
            System.out.println("""
                    ------------------------
                    -----CHIQUISTRIQUIS-----
                    ------------------------""");
            System.out.println("1. Para jugar\n2. Para leer las reglas\n3. Para salir");
            eleccion = in.nextInt();
            switch (eleccion){
                case 1:
                    PrincipalTriqui();
                    break;
                case 2:
                    Rules();
                    break;
            }
        }
    }
    static String[][] principalTriqui = new String[3][3];
    public static void PrincipalTriqui(){
        Scanner in = new Scanner(System.in);
        String turn = "-";
        int[] posicionOcupada = new int[9];
        int entradaTriqui, acumulador = 0;
        boolean dotVerify;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                principalTriqui[i][j] = "-";
            }
        }
        while(!Verificador(principalTriqui)){
            if (acumulador == 9 && !Verificador(principalTriqui)){
                break;
            }
            acumulador++;
            //Turno
            if (acumulador % 2 == 1){
                turn = "X";
            }else {
                turn = "O";
            }
            //Ingresar turno
            do {
                Clear();
                System.out.println("TURNO DEL JUGADOR " + turn + "\n");
                PrintTriqui();
                dotVerify = true;
                entradaTriqui = in.nextInt();
                if (entradaTriqui < 1 || entradaTriqui > 9){
                    dotVerify = false;
                }
                if (posicionOcupada[entradaTriqui - 1] == 1){
                    dotVerify = false;
                }
            }while(!dotVerify);
            //Colocar turno
            posicionOcupada[entradaTriqui - 1] = 1;
            switch (entradaTriqui){
                case 1:
                    principalTriqui[0][0] = turn;
                    break;
                case 2:
                    principalTriqui[0][1] = turn;
                    break;
                case 3:
                    principalTriqui[0][2] = turn;
                    break;
                case 4:
                    principalTriqui[1][0] = turn;
                    break;
                case 5:
                    principalTriqui[1][1] = turn;
                    break;
                case 6:
                    principalTriqui[1][2] = turn;
                    break;
                case 7:
                    principalTriqui[2][0] = turn;
                    break;
                case 8:
                    principalTriqui[2][1] = turn;
                    break;
                case 9:
                    principalTriqui[2][2] = turn;
                    break;
            }
        }
        Clear();
        System.out.println("""
                    ------------------------
                    -----CHIQUISTRIQUIS-----
                    ------------------------""");
        PrintTriqui();
        if (Verificador(principalTriqui)){
            System.out.println("El ganador es el jugador " + turn);
        }else{
            System.out.println("Hubo un empate");
        }
        System.out.print("Enter para regresar: ");
        String enter = in.next();
    }
    public static void PrintTriqui(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + principalTriqui[i][j] + " |");
            }
            System.out.println(" ");
        }
    }
    //Verificador de posiciones
    public static boolean Verificador(String[][] principalTriqui){
        String turn;
        for (int i = 1; i < 3; i++){
            if (i % 2 == 1){
                turn = "X";
            }else {
                turn = "O";
            }
            if(principalTriqui[0][0].equals(turn) && principalTriqui[1][0].equals(turn) && principalTriqui[2][0].equals(turn)) { //Vertical 1
                return true;
            }else if(principalTriqui[0][1].equals(turn) && principalTriqui[1][1].equals(turn) && principalTriqui[2][1].equals(turn)) { //Vertical 2
                return true;
            }else if(principalTriqui[0][2].equals(turn) && principalTriqui[1][2].equals(turn) && principalTriqui[2][2].equals(turn)) { //Vertical 3
                return true;
            }else if(principalTriqui[0][2].equals(turn) && principalTriqui[1][1].equals(turn) && principalTriqui[2][0].equals(turn)) { //Diagonal izquierda
                return true;
            }else if(principalTriqui[0][0].equals(turn) && principalTriqui[0][1].equals(turn) && principalTriqui[0][2].equals(turn)) { //Horizontal 1
                return true;
            }else if(principalTriqui[1][0].equals(turn) && principalTriqui[1][1].equals(turn) && principalTriqui[1][2].equals(turn)) { //Horizontal 2
                return true;
            }else if(principalTriqui[2][0].equals(turn) && principalTriqui[2][1].equals(turn) && principalTriqui[2][2].equals(turn)) { //Horizontal 3
                return true;
            }else if(principalTriqui[0][0].equals(turn) && principalTriqui[1][1].equals(turn) && principalTriqui[2][2].equals(turn)) { //Diagonal derecha
                return true;
            }
        }
        return false;
    }
    public static void Rules(){
        Scanner in = new Scanner(System.in);
        Clear();
        String[][] matrizRules = new String[3][3];
        int acumuladorRules = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                acumuladorRules++;
                matrizRules[i][j] = "| " + acumuladorRules + " |";
            }
        }
        System.out.println("""
                -------------------------------
                ------REGLAS CHIQUISTRIQUIS----
                -------------------------------
                """);
        System.out.println("1. No se puede colocar un punto en una posicion ya colocada");
        System.out.println("2. Siempre comenzará el turno de las X");
        System.out.println("3. Para colocar un punto debes de colocar el número de la posicion de esta manera");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print(matrizRules[i][j]);
            }
            System.out.println(" ");
        }
        System.out.print("Enter para regresar: ");
        String enter = in.nextLine();
    }
    public static void Clear(){
        for (int i = 0; i < 50; i++){
            System.out.println(" ");
        }
    }
}