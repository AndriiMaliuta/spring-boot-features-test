package com.anma.bh.sb.springtesting.core.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Embeddable
public class Address {
    @NotNull
    @Size(max = 100)
    public String addressLine1;

    @NotNull
    @Size(max = 100)
    public String addressLine2;

    @NotNull
    @Size(max = 100)
    public String city;

    @NotNull
    @Size(max = 100)
    public String state;

    @NotNull
    @Size(max = 100)
    public String country;

    @NotNull
    @Size(max = 6)
    public String zipCode;
}
