#ifndef PILAARR_H
#define PILAARR_H

#include <iostream>

template <class T> class Pila {
  T *pila;
  int p;

public:
  Pila(int max = 100) {
    pila = new T[max];
    for (int i = 0; i < max; ++i)
      pila[i] = NULL;
    p = 0;
  }
  ~Pila() { delete pila; }
  inline void meter(T v) { pila[p++] = v; }
  inline T sacar() { return pila[--p]; }
  inline int vacia() { return !p; }
};

#endif
