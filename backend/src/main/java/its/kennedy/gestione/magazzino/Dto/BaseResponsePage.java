package its.kennedy.gestione.magazzino.Dto;

import java.util.List;

public class BaseResponsePage<T> {
 public List<T> list;
  public int pagine=0;
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
