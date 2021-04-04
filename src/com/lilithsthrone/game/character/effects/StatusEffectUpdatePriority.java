package com.lilithsthrone.game.character.effects;

public enum StatusEffectUpdatePriority {
    /** This status effect is updated at the end of every turn. */
    ALWAYS,

    /** This status effect is only updated when the player encounters this NPC. */
    ONDEMAND
}
