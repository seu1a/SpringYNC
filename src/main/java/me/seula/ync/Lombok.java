package me.seula.ync;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lombok {

    public static void main(String[] args) {
        final String hello = "Hello ";
        final String world = "World !";

        System.out.println(hello + world);
    }
}
