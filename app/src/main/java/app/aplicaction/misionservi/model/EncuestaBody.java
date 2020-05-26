package app.aplicaction.misionservi.model;

public class EncuestaBody {
    private int idPregunta;
    private String pregunta;
    private boolean idEstado;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isIdEStado() {
        return idEstado;
    }

    public void setIdEStado(boolean idEStado) {
        this.idEstado = idEStado;
    }
}
