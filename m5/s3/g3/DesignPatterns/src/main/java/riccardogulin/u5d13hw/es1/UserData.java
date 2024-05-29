package riccardogulin.u5d13hw.es1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
public class UserData {
    private String nomeCompleto;
    private int eta;

    public void setData(DataSource ds){
        nomeCompleto = ds.getNomeCompleto();
        eta = ds.getEta();
    }
}
