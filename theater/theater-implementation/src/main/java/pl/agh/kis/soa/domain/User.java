package pl.agh.kis.soa.ejb3.server.impl.domain;

public class User {

    private Integer id;
    private String name;
    private String login;
    private String password;
    private Integer money;

    public User(Integer id, String name, String login, String password, Integer money) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
