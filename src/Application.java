import javax.swing.JOptionPane;

public class Application {
    public static int trava = 0;
    private static int op = 0;

    public static void main(String[] args) throws Exception {
        Celular celular = new Celular(Double.parseDouble(JOptionPane.showInputDialog("Quantos creditos o celular ja tem?")));
        Application.Menu(celular);
    }

    public static void Menu(Celular celular) {
        Telefonema tel;

        op = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu\n1 - Ligar  \n2 - Exibir ligacoes feitas \n3 - Recarregar \n4 - Verificar um telefonema feito \n5 - Quanto gastei em recarga \n6- sair"));
        switch (op) {
            case 1:
                LimpaTela();
                tel = new Telefonema();
                tel.setHorario(JOptionPane.showInputDialog("Que horas sao?"));
                tel.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Para qual numero esta ligando?")));
                tel.setTempoDeLigacao(
                        Integer.parseInt(JOptionPane.showInputDialog("Quantos segundos durou a ligacao?")));
                try {
                    celular.ligacao(tel);
                } catch (FaltaCreditosException e) {
                    System.out.println(e.getMessage());
                }
                Menu(celular);

            case 2:
                LimpaTela();
                celular.imprimir();
                Menu(celular);

            case 3:
                LimpaTela();
                celular.recarregar(
                        (Double.parseDouble(JOptionPane.showInputDialog("Quantos creditos deseja recarregar?"))));
                Menu(celular);

            case 4:
                LimpaTela();
                tel = new Telefonema();
                tel.setHorario(JOptionPane.showInputDialog("Que horas voce ligou?"));
                tel.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Para qual numero voce ligou?")));
                tel.setTempoDeLigacao(
                        Integer.parseInt(JOptionPane.showInputDialog("Quantos segundos durou a ligacao?")));
                if (celular.verificarTelefonema(tel))
                    System.out.println("Ligacao foi encontrada no seu historico: ");
                else
                    System.out.println("Essa ligacao nao esta no seu historico de ligacoes.");
                Menu(celular);
            case 5:
                LimpaTela();
                System.out.println("Voce ja recarregou um total de " + celular.valorRecargas());
                Menu(celular);

            case 6:
                LimpaTela();
                System.out.println("Saindo da aplicacao, volte sempre!");
                System.exit(0);

            default:
                Menu(celular);

        }
    }

    public static void LimpaTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
