public class Celular {
    public double valorRecargas;
    public double creditosAtuais;
    public static int numeroDeTelefonemas = 0;
    public Telefonema[] telesfonemas = new Telefonema[50];

    public Celular(double valorCreditos) {
        this.creditosAtuais = valorCreditos;
    }

    public double getCreditos() {
        return this.creditosAtuais;
    }

    public void ligacao(Telefonema tel) throws FaltaCreditosException {
        double creditoGasto = tel.tempoDeLigacao * 0.002;
        if (creditoGasto >= getCreditos()) {
            throw new FaltaCreditosException(
                    "Voce nao tem creditos suficientes para fazer essa ligacao. Por favor faca uma recarga!");
        } else {
            setCreditos(getCreditos() - creditoGasto);
            telesfonemas[numeroDeTelefonemas] = tel;
            numeroDeTelefonemas++;
        }
    }

    public void imprimir() {
        int i = 1;
        for (Telefonema telefonema : telesfonemas) {
            try {
                System.out.println("---------------------------------");
                System.out.println("Horario da ligacao: " + telefonema.getHorario());
                System.out.println("Numero ligado: " + telefonema.getNumero());
                System.out.println("Duracao da ligacao: " + telefonema.getTempoDeLigacao());
                System.out.println("------ Telefonema numero " + i++ + " ------\n");
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    public void recarregar(double valorCreditos) {
        setCreditos(getCreditos() + valorCreditos);
        setValorRecargas(getValorRecargas() + valorCreditos);
    }

    public boolean verificarTelefonema(Telefonema tel) {
        try {
            for (Telefonema telefonema : telesfonemas) {
                if (tel.equals(telefonema)) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    public double valorRecargas() {
        return valorRecargas;
    }

    public double getValorRecargas() {
        return this.valorRecargas;
    }

    public void setValorRecargas(double valorRecargas) {
        this.valorRecargas = valorRecargas;
    }

    public void setCreditos(double creditosAtuais) {
        this.creditosAtuais = creditosAtuais;
    }

}