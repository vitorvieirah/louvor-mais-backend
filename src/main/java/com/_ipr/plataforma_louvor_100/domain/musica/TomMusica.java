package com._ipr.plataforma_louvor_100.domain.musica;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TomMusica {
    C( 0,"C (Dó)"),
    C_SHARP_D_FLAT(1, "C#/Db (Dó#/Réb)"),
    D(2, "D (Ré)"),
    D_SHARP_E_FLAT(3, "D#/Eb (Ré#/Mib)"),
    E(4, "E (Mi)"),
    F(5,"F (Fá)"),
    F_SHARP_G_FLAT(6,"F#/Gb (Fá#/Solb)"),
    G(7,"G (Sol)"),
    G_SHARP_A_FLAT(8,"G#/Ab (Sol#/Láb)"),
    A(9,"A (Lá)"),
    A_SHARP_B_FLAT(10,"A#/Bb (Lá#/Sib)"),
    B(11,"B (Si)"),

    // Menores
    CM(12,"Cm (Dó menor)"),
    C_SHARP_D_FLAT_M(13,"C#m/Dbm (Dó#m/Réb m)"),
    DM(14,"Dm (Ré menor)"),
    D_SHARP_E_FLAT_M(15,"D#m/Ebm (Ré#m/Mib m)"),
    EM(16,"Em (Mi menor)"),
    FM(17,"Fm (Fá menor)"),
    F_SHARP_G_FLAT_M(18,"F#m/Gbm (Fá#m/Solb m)"),
    GM(19,"Gm (Sol menor)"),
    G_SHARP_A_FLAT_M(20,"G#m/Abm (Sol#m/Láb m)"),
    AM(21,"Am (Lá menor)"),
    A_SHARP_B_FLAT_M(22,"A#m/Bbm (Lá#m/Sib m)"),
    BM(23,"Bm (Si menor)");

    private final int codigo;
    private final String descricao;
}