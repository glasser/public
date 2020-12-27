package com.languagelatte.simplechaos_java;

import com.languagelatte.simplechaos_java.attacks.Attack;
import com.languagelatte.simplechaos_java.attacks.ErrorAttack;
import com.languagelatte.simplechaos_java.attacks.ExceptionAttack;
import com.languagelatte.simplechaos_java.attacks.JvmCrashAttack;
import com.languagelatte.simplechaos_java.attacks.LatencyAttack;
import java.util.Map;
import java.util.Properties;

public class RandomChaosAttacks implements ChaosAttacks {

  // 1. Is Simple Chaos Enabled?
  // 2. Is Random Chaos Enabled?
  // 3. Is correct Day of week, and Hour
  // 4. Is the specific method Enabled?
  // 5. Id the random number <= than the chance?

  ChaosProperties properties;
  Attack exception;
  Attack latency;
  Attack jvmCrash;
  Attack error;

  public RandomChaosAttacks() {
    this.exception = new ExceptionAttack();
    this.error = new ErrorAttack();
    this.latency = new LatencyAttack();
    this.jvmCrash = new JvmCrashAttack();
    this.properties = new ChaosPropertiesDefaultImpl();
    this.properties.loadProperties();
  }

  public RandomChaosAttacks(ChaosProperties chaosProperties) {
    this.exception = new ExceptionAttack();
    this.error = new ErrorAttack();
    this.latency = new LatencyAttack();
    this.jvmCrash = new JvmCrashAttack();
    this.properties = chaosProperties;
    this.properties.loadProperties();
  }

  public RandomChaosAttacks(Map<String, String> properties) {
    this.exception = new ExceptionAttack();
    this.error = new ErrorAttack();
    this.latency = new LatencyAttack();
    this.jvmCrash = new JvmCrashAttack();
    this.properties = new ChaosPropertiesDefaultImpl();
    this.properties.loadProperties(properties);
  }

  public RandomChaosAttacks(Properties properties) {
    this.exception = new ExceptionAttack();
    this.error = new ErrorAttack();
    this.latency = new LatencyAttack();
    this.jvmCrash = new JvmCrashAttack();
    this.properties = new ChaosPropertiesDefaultImpl();
    this.properties.loadProperties(properties);
  }

  // public RandomChaosAttacks(Attack exception) {
  //   this.exception = exception;
  // }

  @Override
  public void exception() {
    if (!properties.getBooleanProperty(SimpleChaosConstants.ENABLED)) {
      return;
    }

    if (!properties.getBooleanProperty(SimpleChaosConstants.RANDOM_CHAOS_EXCEPTION_ENABLED)) {
      return;
    }
    if (Math.random()
        > 1 - properties.getDoubleProperty(SimpleChaosConstants.RANDOM_CHAOS_EXCEPTION_CHANCE)) {
      exception.attack(properties);
    }
  }

  @Override
  public void error() {
    if (!properties.getBooleanProperty(SimpleChaosConstants.ENABLED)) {
      return;
    }

    if (!properties.getBooleanProperty(SimpleChaosConstants.RANDOM_CHAOS_ERROR_ENABLED)) {
      return;
    }
    if (Math.random()
        > 1 - properties.getDoubleProperty(SimpleChaosConstants.RANDOM_CHAOS_ERROR_CHANCE)) {
      exception.attack(properties);
    }
  }

  @Override
  public void jvmCrash() {
    if (!properties.getBooleanProperty(SimpleChaosConstants.ENABLED)) {
      return;
    }

    if (!properties.getBooleanProperty(SimpleChaosConstants.RANDOM_CHAOS_JVMCRASH_ENABLED)) {
      return;
    }
    if (Math.random()
        > 1 - properties.getDoubleProperty(SimpleChaosConstants.RANDOM_CHAOS_JVMCRASH_CHANCE)) {
      exception.attack(properties);
    }
  }

  @Override
  public void latency() {
    if (!properties.getBooleanProperty(SimpleChaosConstants.ENABLED)) {
      return;
    }

    if (!properties.getBooleanProperty(SimpleChaosConstants.RANDOM_CHAOS_LATENCY_ENABLED)) {
      return;
    }
    if (Math.random()
        > 1 - properties.getDoubleProperty(SimpleChaosConstants.RANDOM_CHAOS_LATENCY_CHANCE)) {
      exception.attack(properties);
    }
  }
}