/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circulerlinklist;

/**
 *
 * @author tushar
 */
public class Main {

    public static int get() {
        try {
            return 1;

        } catch (Exception e) {
            return 2;

        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(get());
    }
}
