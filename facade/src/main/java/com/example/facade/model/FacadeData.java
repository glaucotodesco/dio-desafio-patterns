package com.example.facade.model;

import com.example.facade.client.Info;
import com.example.facade.client.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class FacadeData {

    @NonNull
    private Model model;

    private Info info;

}
