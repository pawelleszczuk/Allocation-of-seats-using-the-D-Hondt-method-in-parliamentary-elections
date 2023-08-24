# Allocation-of-seats-using-the-D-Hondt-method-in-parliamentary-elections

1. At the beginning enter the input file name with its extension (my file is input.csv). File must be in the project's path.

2. You can modify this input file (for example swap or delete rows), but you can't swap columns.

3. You can also create your own file, but every row must have 6 columns (their names in brackets) divided by comma (so don't enter commas in String types), with following types:
   int (candidate's individual index in elections)
   String (name of election committee)
   int (candidate's number on the committee list)
   String (surname)
   String (name)
   int (number of votes received by that candidate)

4. You can freely define the number of seats to be distributed (non-negative int), but it also must be reasonable number (in a 100% safe case, a maximum of as many as there are candidates on the shortest list), because it's obvious that if there were, for example, 50 seats to be divided, then probably each of the lists that would have a chance of getting into parliament would have at least 50 candidates on the list.
   The input file was created using real data (but I changed the names of the candidates; the rest is unchanged) from the 2019 elections to the Sejm of the Republic of Poland from the electoral district No. 24 Bialystok.
(results and more here: https://sejmsenat2019.pkw.gov.pl/sejmsenat2019/pl/wyniki/sejm/okr/24)

5. All tables (pre-assigned file extension is .csv) and summary of election results (here is .txt) can be exported to external files. They will be exported to the project's path. You only need to enter the filename without the extension.
