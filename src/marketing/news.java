package marketing;

import Classes.news_portal;

import java.io.Serializable;
import java.util.List;

public class news implements Serializable {
    private List<news_portal>list;
    private List<news_portal>list2;

    public void setList2(List<news_portal> list2) {
        this.list2 = list2;
    }

    public List<news_portal> getList2() {
        return list2;
    }

    public void setList(List<news_portal> list) {
        this.list = list;
    }

    public List<news_portal> getList() {
        return list;
    }
}
