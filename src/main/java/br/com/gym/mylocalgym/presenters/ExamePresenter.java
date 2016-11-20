package br.com.gym.mylocalgym.presenters;

/**
 *
 * @author Luciano
 */
public class ExamePresenter {

    private byte[] exame;

    public ExamePresenter(byte[] exame) {

        this.exame = exame;
    }

    public byte[] getExame() {
        return exame;
    }

    public void setExame(byte[] exame) {
        this.exame = exame;
    }

}
