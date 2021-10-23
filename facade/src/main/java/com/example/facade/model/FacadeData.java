package com.example.facade.model;

import com.example.facade.client.Info;
import com.example.facade.client.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacadeData {
    private Model model;
    private Info info;
}
