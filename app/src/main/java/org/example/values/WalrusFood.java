package org.example.values;

public class WalrusFood {
    private String name;

    public WalrusFood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WalrusFood) {
            return ((WalrusFood) obj).name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
