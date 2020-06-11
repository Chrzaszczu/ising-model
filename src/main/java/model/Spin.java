package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.enums.State;

@Getter
@Setter
@AllArgsConstructor
public class Spin
{
    private State state;
    private Index index;
}
