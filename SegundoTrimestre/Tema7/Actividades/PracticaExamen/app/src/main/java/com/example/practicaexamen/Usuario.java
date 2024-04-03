package com.example.practicaexamen;

public class Usuario {


    private int id;
    private String nombre;
    private String telefono;
    private int avatar;

    public Usuario() {
    }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getTelefono() {
                return telefono;
        }

        public void setTelefono(String telefono) {
                this.telefono = telefono;
        }

        public int getAvatar() {
                return avatar;
        }

        public void setAvatar(int avatar) {
                this.avatar = avatar;
        }
}
