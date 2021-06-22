package its.kennedy.gestione.magazzino.Dto;

import java.util.List;

public class BaseResponsePage<T> {

    private List<T> list;

    private int pagine = 0;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

}
