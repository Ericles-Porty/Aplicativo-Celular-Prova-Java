public class Telefonema {
    public int numero;
    public int tempoDeLigacao;
    public String horario;

    public Telefonema() {

    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (o instanceof Telefonema)) {
            Telefonema tel = (Telefonema) o;
            if (this.horario.equalsIgnoreCase(tel.horario) && this.numero == tel.numero && this.tempoDeLigacao == tel.tempoDeLigacao) {
                return true;
            }
        }
        return false;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTempoDeLigacao() {
        return this.tempoDeLigacao;
    }

    public void setTempoDeLigacao(int tempoDeLigacao) {
        this.tempoDeLigacao = tempoDeLigacao;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
