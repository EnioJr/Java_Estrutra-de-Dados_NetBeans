package torresdehanoi;

public class Torre {

// Método que realiza (imprime) o movimento de um disco entre dois pinos
        public void mover(int O,int T, int D) {
            System.out.println(O + " -> "+T+ " -> " + D);
        }

// Método que implementa a recursão
// n = número de discos a serem movimentados
// O = atual pino origem
// D = atual pino destino
// T = atual pino de trabalho
        public void hanoi(int n, int O, int D, int T) {

            if (n > 0) {
                hanoi(n - 1, O, T, D);	//executa hanoi para mover n-1 discos 
                //da origem para o trabalho

                mover(O,T, D);		//mover disco do "pino O" (origem atual) 
                //para o "pino D" (destino atual)

                hanoi(n - 1, T, D, O);	//executa hanoi para mover n-1 discos 
                //do trabalho para destino
            }
        }
    }
