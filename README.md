# ising-model

W fizyce statystycznej model Isinga jest uproszczonym model matematycznym ferromagnetyka. 
Model opisywanego ciała jest przedstawiony jako N = n × n wymiarowa sieć o periodycznych warunkach brzegowych. 
W węzłach sieci, których jest n^2 znajdują się spiny elektronów σ odpowiedzialne za magnetyzację ciała. Wartości spinów
mogą przyjmować jedną z dwóch dyskretnych wartości, tj. s = ±1/2, przy czym σ = 2s. W dwuwymiarowym modelu Isinga spiny elektronów oddziałują z zewnętrznym polem magnetycznym B i z najbliższymi sąsiadami. Hamiltonian, czyli energię układu dwuwymiarowego wyznacza się ze wzoru:

![\mathcal{H} = -J\sum_{<ij>} \sigma_{i}\sigma_{j} - B\sum_{i}^{N}\sigma_{i}](https://latex.codecogs.com/gif.latex?%5Cmathcal%7BH%7D%20%3D%20-J%5Csum_%7B%3Cij%3E%7D%20%5Csigma_%7Bi%7D%5Csigma_%7Bj%7D%20-%20B%5Csum_%7Bi%7D%5E%7BN%7D%5Csigma_%7Bi%7D)

gdzie: < ij > - sumowanie po najbliższych sąsiadach, J - stała oddziaływania wymiennego, B - indukcja magnetyczna.

Sumowanie w pierwszym członie wzoru odbywa się uwzględniając periodyczne warunki brzegowe, czyli takie, dla których przyjmuje się, że spiny położone po zewnętrznej stronie sieci, za swoich sąsiadów mają także węzły położone po przeciwnej stronie. Przykładową sytuację przedstawia poniższy rysunek.

<p align="center">
<img src = https://github.com/Chrzaszczu/ising-model/blob/master/periodic.png width="200" height = "200">
</p>

stała oddziaływania wymiennego J określa charakter oddziaływania między spinami:
* J > 0 - oddziaływanie jest ferromagnetyczne
* J < 0 - oddziaływanie jest antyferromagnetyczne
* J = 0 - oddziaływanie między spinami nie występuje

# Metoda Monte-Carlo

Metoda Monte Carlo w ogólności bazuje na ukazaniu zmian zachodzących w czasie
w modelowanym układzie. Zmiany te nie zachodzą w ściśle określony sposób, lecz na
drodze pewnego procesu stochastycznego zależnego od rozpatrywanego problemu.
Ze względu na charakter tej metody, wyniki wykonanych symulacji nie są powtarzalne
i obarczone są pewnym błędem wynikającym z czynników pseudolosowych. Dla modelu Isinga 
metoda Monte Carlo Metropolisa (MCM) można przedstawić w postaci poniższego schematu blokowego.

<p align="center">
<img src = https://github.com/Chrzaszczu/ising-model/blob/master/mcm.png width="400" height = "420">
</p>

