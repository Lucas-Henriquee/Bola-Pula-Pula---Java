//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique

package trabalhofinal_oo.bola_pula_pula;

public class Jogo {
     private final int lateral = 30, altura = 20;
     private int vidas, bolinhas;
     private Tabuleiro[][] tabuleiro = new Tabuleiro[altura][lateral];

     public Jogo() {
          vidas = 3;
          for (int i = 0; i < altura; i++) {
               for (int j = 0; j < lateral; j++) {
                    tabuleiro[i][j] = new Tabuleiro();
               }
          }

          tabuleiro[19][14] = new Barra();
          tabuleiro[19][15] = new Barra();
          tabuleiro[19][16] = new Barra();
          tabuleiro[18][15] = new Bolinha();
          tabuleiro[0][1] = new Blocos();
          tabuleiro[0][2] = new Blocos();
          tabuleiro[0][5] = new Blocos();
          tabuleiro[0][8] = new Blocos();
          tabuleiro[0][9] = new Blocos();
          tabuleiro[0][14] = new Blocos();
          tabuleiro[0][25] = new Blocos();
          tabuleiro[0][26] = new Blocos();
          tabuleiro[0][27] = new Blocos();
          tabuleiro[0][28] = new Blocos();
          tabuleiro[0][29] = new Blocos();
          tabuleiro[1][28] = new Blocos();
          tabuleiro[2][28] = new Blocos();
          tabuleiro[1][26] = new Blocos();
          tabuleiro[0][27] = new Blocos();
          tabuleiro[0][28] = new Blocos();
          tabuleiro[0][0] = new Blocos();
          tabuleiro[1][2] = new Blocos();
          tabuleiro[1][3] = new Blocos();
          tabuleiro[2][3] = new Blocos();
          tabuleiro[1][4] = new Blocos();
     }

     public void start() {
          while (vidas > 0) {
               bolinhas = 1;

               while (bolinhas > 0) {
                    // TODO: Ajustar o jogo em si
                    show();
                    bolinhas--;
               }
               vidas--;
          }
     }

     private void generateB() {
          // TODO: Fazer o metodo que vai gerar a linha de blocos e inserir no Tabuleiro
          // TODO: e passar todos os blocos 1 pra baixo
     }

     public void show() {
          for (int i = 0; i < altura + 2; i++) {
               if (i == 0) {
                    lifes();
               } else {
                    for (int j = 0; j < lateral + 1; j++) {
                         if (i == 1 && j != lateral) {
                              System.out.print("-");
                              System.out.print("-");
                         } else if (i == 1 && j == lateral) {

                         } else {
                              if (j == 0) {
                                   System.out.print("|");
                              } else {
                                   if (j == lateral) {
                                        System.out.print("|");
                                   } else {
                                        mostra(i - 2, j - 1);
                                   }
                              }
                         }
                    }
               }
               System.out.println();
          }
     }

     private void mostra(int i, int j) {
          tabuleiro[i][j].print();
     }

     private void lifes() {
          switch (vidas) {
               // TODO: Inserir os corações a serem printados
               case 1:
                    System.out.println("Vidas: ❤️");
                    break;
               case 2:
                    System.out.println("Vidas: ❤️❤️");
                    break;
               case 3:
                    System.out.println("Vidas: ❤️❤️❤️");
                    break;
          }
     }
}
