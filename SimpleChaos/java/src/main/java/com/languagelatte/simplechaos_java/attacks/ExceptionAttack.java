package com.languagelatte.simplechaos_java.attacks;

import com.languagelatte.simplechaos_java.ChaosProperties;

public class ExceptionAttack implements Attack {

  @Override
  public void attack(ChaosProperties properties) {
    throw new RuntimeException("Chaos Attack Exception");
  }
}