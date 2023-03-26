package org.example.interfaces;

import org.example.Receiver;

import java.util.ArrayList;

public interface Execute {
    String execute(ArrayList<String> arguments , Receiver worker);
}
