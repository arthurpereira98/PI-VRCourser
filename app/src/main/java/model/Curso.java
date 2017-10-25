package model;


public class Curso {
    private Integer _id;
    private String curso;
    private String dt_criacao;
    private String dt_completado;

    public Curso(){}

    public Curso(Integer id, String curso, String dt_criacao, String dt_completado){
        this._id = id;
        this.curso = curso;
        this.dt_criacao = dt_criacao;
        this.dt_completado = dt_completado;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        curso = curso;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getDt_completado() {
        return dt_completado;
    }

    public void setDt_completado(String dt_completado) {
        this.dt_completado = dt_completado;
    }

}
