package com.fribbels.model;

public class MergeHero {

    private Integer awaken;
    private Integer stars;
    private String name;
    private String id;
    private Hero data;

    public MergeHero(Integer awaken, Integer stars, String name, String id, Hero data) {
        this.awaken = awaken;
        this.stars = stars;
        this.name = name;
        this.id = id;
        this.data = data;
    }

    public Integer getAwaken() {
        return awaken;
    }

    public void setAwaken(Integer awaken) {
        this.awaken = awaken;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hero getData() {
        return data;
    }

    public void setData(Hero data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MergeHero [awaken=" + awaken + ", stars=" + stars + ", name=" + name + ", id=" + id + ", data=" + data
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((awaken == null) ? 0 : awaken.hashCode());
        result = prime * result + ((stars == null) ? 0 : stars.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MergeHero other = (MergeHero) obj;
        if (awaken == null) {
            if (other.awaken != null)
                return false;
        } else if (!awaken.equals(other.awaken))
            return false;
        if (stars == null) {
            if (other.stars != null)
                return false;
        } else if (!stars.equals(other.stars))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }

}
