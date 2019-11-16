/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;


public class Sistema {

    private ArrayList<Categoria> categorias;
    private ArrayList<Elemento> restaurantes;
    private ArrayList<Usuario> usuarios;
    public static  Sistema INSTANCIA = getInstance();
    public static final Usuario USUARIO = new Usuario("Jeyson Amado");

    private synchronized static void createInstance() {
        if (INSTANCIA == null) { 
            INSTANCIA = new Sistema();
        }
    }
 
    public static Sistema getInstance() {
        createInstance();
        return INSTANCIA;
    }
    
    private Sistema() {
        //instancias de los arreglos
        categorias = new ArrayList<>(); 
        restaurantes = new ArrayList<>();
        usuarios = new ArrayList<>();

        // creacion de los categorias
        Categoria rapida = new Categoria("Comida Rapida");
        Categoria corriente = new Categoria("Comida Corriente");
        Categoria carta = new Categoria("Platos a la Carta");
        Categoria postre = new Categoria("Postres");
        Categoria bebidas = new Categoria("Bebidas");

        //se agregan los categorias
        categorias.add(rapida);
        categorias.add(corriente);
        categorias.add(carta);
        categorias.add(postre);
        categorias.add(bebidas);
        
    

        //se crean los usuarios
        String[] nombreUsuarios = {"Juan Bernal", "Diego Pedroza", "Carol Gonzáles", "Andres Caro", "Jaime Vargas", "Esteban Hernandez", "Ricardo Noguera", "Gina Cely", "Luisa Jimenez", "Margarita Dias"};
        for (String nombreUsuario : nombreUsuarios) {
            Usuario usuNuevo = new Usuario(nombreUsuario);
            usuarios.add(usuNuevo);
        }

        //se crean los comentarios
        String[] comentarios = {"Genial, me encanta este restaurante, no puede existir un restaurante mejor!", "Lo que cambiaría es que no pongan platos tan simples,que cambien partes del menu", "Es demasiado adictivo, muy bueno. Según vas probando platos nuevos, te das cuenta que son muy buenos", "para mi es muy difícil pagar platos tan costozos", "Ojalá hicieran más platos, porque es impresionante!", "El restaurante está muy bien. Es bello y agradable. Pero es muy pequeño y demasiado caluroso. \n Además, llevan más de 2 años sin añadir platos. ", "Muchas felicidades a los dueños.", "El restaurante es maravilloso y super futurístico. Me encanta.", "restaurante super bonito y bueno para pasar el tiempo entretenido,me ha encantado", "Un restaurante aunque algo antiguo se renueva muy bien.", "Me encanta!", "la verdad esq es super guay este restaurante", "El mejor almuerzo casero que puedes encontrar en Sogamoso.", "Excelente servicio, me encanto.", "Espectacular la comida, felicidades a la Chef.", "Una atención muy buena la comida deliciosa me encanto todo súper.", "Muy bueno, La atención y su gente. La comida es realmente deliciosa, no veo la hora de volver ¡Felicitaciones!", "Además, bien ubicado. Cositas ricas. Variado bien atendido y económico.", "Riquísimo me encanto el lugar y el servicio está agradable del lugar"};
        String[] descripciones = {"El restaurante el laurel está ubicado en el barrio el rosario, el cual busca resaltar sabores caseros en diferentes presentaciones\nCarrera 14 # 5-31",
            "La Pizza del mono es denominado por muchos como la mejor pizza de la ciudad de Sogamoso. Distinguida por su rico sabor y variedad.\nCarrera 11 No. 20 -–48\nLlamar 312 4909424",
            "Las pizzas de Watson se distinguen por su excepcional servicio y delicioso sabor, sin mencionar el sin número de ofertas especiales que ofrece a sus clientes.\nCarrera 11 N° 20 a - 11\nLlamar 7 70 68 39",
            "Un Restaurante ubicado en el centro de la ciudad en la que su gran variedad de platillos disponibles, además de su indiscutible sabor la posicionan como una de los mejores en la ciudad.\nCarrera 11 # 12 –61\nLlamar 7700320",
            "PLATOS:\n-Crema de almeja\n-Paella\n-Cazuela de mariscos\n-Salmón a la plancha\n-Ceviche de pescado\n-Mojarra frita",
            "Platos:\n-Nachos con queso\n-Carne a la parrilla\n-Plátano relleno\n-Picaditas mixtas\n-Pescados\n-Comida mexicana\nCarrera 11 2-76 sur, Sogamoso\nLlamar 321 4877499 ",
            "Platos:\n-Chupín de pescado\n-Milanesa de pescado\n-Guarnición\n-Tortitas de papa con salmón trozado y queso\n-Mojarra frita\n-Sopitas de pescado\nCarrera 10 No 8 - 21, Sogamoso, Boyacá",
            "CALLE 13 # 13 – 55,  centro Sogamoso -  311 5642289",
            "Bebe un espectacular café o deléitate con nuestros especiales platillos, con una maravillosa vista y gran ambiente.\nCra 7# 20-44\nLlamar 313 2346721",
            "Nuestra especialidad es la comida asiática y el buen servicio, con los ingredientes más frescos.",
            "Pasa un buen rato con tus amigos junto a la mejor cerveza artesanal y los mejor de nuestra carta.\nCarrera 11 # 3-47 sur estaciòn de servicio Brìo y Calle 15 #10-44 centro.\n305 3206828",
            "Si quieres disfrutar de los mejores churros de la ciudad y de una comida rica y saludable ven a Green \nCra11 # 18-20\nNum: 3217896756\nHora:  de 8 am a 8pm",
            "¡Uno de los Restaurantes de Comida Rápida más frecuentados por su ubicación, su especialidad y sus bajos precios hacen de este un lugar agradable para comer!\nDomicilios: 3124340766\nDirección: Carrera 11 Calle 19ª (Esquina)",
            "¡Realmente el mejor Local de Empanadas de la Ciudad! Su variedad y servicio al Cliente hace que este sea uno de los lugares más visitados y recomendados por muchos.\nDomicilios: 313 4722110\nDirección: Carrera 11 No.14-96, Centro",
            "¡Ven y disfruta de comida saludable y realmente deliciosa! La cantidad de sabores y postres que se pueden probar en este lugar son realmente deliciosos además de nutritivos\nDomicilios: 313 4722110\nDirección: Calle 15 #10-112",
            "¡Una de las mejores Pizzerías de la Ciudad! Su excelente servicio y su calidad con la comida hacen de este restaurante un lugar muy agradable y recomendable para comer.\nDomicilios: 312 3150316\nDirección: Carrera 11 No. 1948"};
        //se crea cada juego para cada genero
        int[] numCategorias = {1, 0, 0, 1, 2, 2, 2, 2, 2, 2, 4, 3, 0, 0, 4, 0};
        String[] listaRestaurantes = {"El Laurel", "La Pizza del Mono", "Pizzas de Watson", "La Colonial", "El lago", "El Bambú", "El dorado", "La Julieta", "El Alfarero", "La Popa", "Entre Palos", "Green", "Rica Papa", "Ranch Factory", "Ciclo Fruta", "Pizza King"};
        int i = 0;
        for (String string : listaRestaurantes) {
            float random = new Random().nextFloat();
            ElementoDirector director = new ElementoDirector();
            ElementoBuilder elementoBuilder = null;
            int num = new Random().nextInt();
            if((num%2)==0){
                elementoBuilder = new Restaurante();
                director.setElementoBuilder(elementoBuilder);
            director.construirElemento(new Image("/Imagenes/icono" + string + ".png"), string, descripciones[i], random * 100, categorias.get(numCategorias[i]));
            } else {
                elementoBuilder = new Bar();
                director.setElementoBuilder(elementoBuilder);
            director.construirElemento(new Image("/Imagenes/icono" + string + ".png"), string, descripciones[i], random * 100, categorias.get(numCategorias[i]));
            }
            
            try {
                elementoBuilder.elemento.getImagenesAdicionales().add(new Image("/Imagenes/img1" + string + ".png"));
                elementoBuilder.elemento.getImagenesAdicionales().add(new Image("/Imagenes/img2" + string + ".png"));
                elementoBuilder.elemento.getImagenesAdicionales().add(new Image("/Imagenes/img3" + string + ".png"));
                elementoBuilder.elemento.getImagenesAdicionales().add(new Image("/Imagenes/img4" + string + ".png"));
                elementoBuilder.elemento.getImagenesAdicionales().add(new Image("/Imagenes/img5" + string + ".png"));
            } catch (Exception ex) {
            }
            for (Usuario usuario : usuarios) {
                elementoBuilder.elemento.getComentarios().add(new Comentario(comentarios[((int) (new Random().nextFloat() * comentarios.length))], usuario));
            }
            restaurantes.add(elementoBuilder.elemento);
            i++;
        }
        
        
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Elemento> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(ArrayList<Elemento> restaurantes) {
        this.restaurantes = restaurantes;
    }

}
