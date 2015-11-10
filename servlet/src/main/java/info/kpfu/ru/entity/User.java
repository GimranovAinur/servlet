package info.kpfu.ru.entity;


public class User {
    int id;
    String mail;
    String pwd;
    String sex;
    String chb;
    String info;
    public User(){}

    public User(String m,String p){
        mail = m;
        pwd = p;
    }
    public User(int d,String m,String p,String s,String c,String i){
        id = d;
        mail = m;
        pwd = p;
        sex = s;
        chb = c;
        info = i;
    }

    public User(String m,String p,String s,String c,String i){
        mail = m;
        pwd = p;
        sex = s;
        chb = c;
        info = i;
    }

    public String getMail() {
        return mail;
    }

    public String getChb() {
        return chb;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setChb(String chb) {
        this.chb = chb;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
