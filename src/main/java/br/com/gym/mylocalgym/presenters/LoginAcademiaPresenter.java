/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Academia;

/**
 *
 * @author Matheus
 */
public class LoginAcademiaPresenter {

    private Integer id;

    public LoginAcademiaPresenter(Academia academia) {
        
        this.id = academia.getId();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
