import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) throws Exception {

        Campo[][] velha = new Campo[3][3];
        char simboloAtual = 'X';
        Boolean game = true;
        char vitoria = ' ';
        Scanner scan = new Scanner(System.in);

        iniciarJogo(velha);

        while(game == true){
            desenhaJogo(velha);
            vitoria = verificaVitoria(velha);
            if(deuVelha(velha) == true){
                System.out.println("DEU VELHA");
                break;
            }
            if(vitoria != ' '){
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            }
            try {
                if(verificaJogada(velha,jogar(scan, simboloAtual), simboloAtual)){
                    if(simboloAtual == 'X'){
                        simboloAtual = 'O';
                    }else {
                        simboloAtual = 'X';
                    }
                }
            } catch (Exception e) {
                System.out.println("ERRO ;-;");
            }
        }
        System.out.println("END GAME");

    }

    public static void desenhaJogo(Campo[][] velha){
        limparTela();
        System.out.println("   0    1    2");
        System.out.printf("0   %c | %c | %c %n",velha[0][0].getSimbolo(),velha[0][1].getSimbolo(),velha[0][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("1   %c | %c | %c %n",velha[1][0].getSimbolo(),velha[1][1].getSimbolo(),velha[1][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("2   %c | %c | %c %n",velha[2][0].getSimbolo(),velha[2][1].getSimbolo(),velha[2][2].getSimbolo());
    }

    public static void limparTela(){ // """""LIMPA"""""
        for(int cont=0;cont<200;cont++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, char sa){
        int p[] = new int[2];
        System.out.printf("%n%s %c%n%n","Quem joga: ",sa);
        System.out.print("Informe a linha: ");
        p[0] = scan.nextInt();
        System.out.print("Informe a coluna: ");
        p[1]=scan.nextInt();
        return p;
    }

    public static Boolean verificaJogada(Campo[][] velha,int p[], char simboloAtual){
        if(velha[p[0]][p[1]].getSimbolo() == ' '){
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }else {
            return false;
        }
    }

    public static void iniciarJogo(Campo[][] velha){
        for(int l=0;l<3;l++){
            for(int c=0;c<3;c++){
                velha[l][c] = new Campo();
            }
        }
    }

    public static Boolean deuVelha(Campo[][] velha){
        int dv = 0;
        Boolean result;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(velha[i][j].getSimbolo() != ' '){
                    dv++;
                }
            }
        }
        if(dv == 9){
            result = true;
        }else {
            result = false;
        }

        return result;
    }

    public static char verificaVitoria(Campo[][] velha){
        char winner=' ';
        
        if(velha[0][0].getSimbolo() == velha[0][1].getSimbolo() && velha[0][1].getSimbolo() == velha[0][2].getSimbolo()){
            winner = velha[0][0].getSimbolo();
        }else {
            if(velha[0][0].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][2].getSimbolo()){
                winner = velha[0][0].getSimbolo();
            }else {
                if(velha[0][0].getSimbolo() == velha[1][0].getSimbolo() && velha[1][0].getSimbolo() == velha[2][0].getSimbolo()){
                    winner = velha[0][0].getSimbolo();
                }else {
                    if(velha[0][1].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][1].getSimbolo()){
                        winner = velha[0][1].getSimbolo();
                    }else {
                        if(velha[0][2].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][0].getSimbolo()){
                            winner = velha[0][2].getSimbolo();
                        }else {
                            if(velha[0][2].getSimbolo() == velha[1][2].getSimbolo() && velha[1][2].getSimbolo() == velha[2][2].getSimbolo()){
                                winner = velha[0][2].getSimbolo();
                            }else {
                                if(velha[1][0].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[1][2].getSimbolo()){
                                    winner = velha[1][0].getSimbolo();
                                }else {
                                    if(velha[2][0].getSimbolo() == velha[2][1].getSimbolo() && velha[2][1].getSimbolo() == velha[2][2].getSimbolo()){
                                        winner = velha[2][0].getSimbolo();
                                    }else {
                                        winner = ' ';
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return winner;
    }
    

}
