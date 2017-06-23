/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.apistats.exceptions;

/**
 *
 * @author Elvis
 */
public class RegistroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = -8607416063037543139L;

	public RegistroNaoEncontradoException(String string) {
        super(string);
    }
    
}
