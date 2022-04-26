package net.ent.etrs.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
public abstract class AbstractEntity {

    @Getter
    private final String id = UUID.randomUUID().toString();

}
