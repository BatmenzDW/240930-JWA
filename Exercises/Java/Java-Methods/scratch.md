# Decision Table
| Case      | snake            | screaming         | camel            | pascal            |
|-----------|------------------|-------------------|------------------|-------------------|
| snake     | NA               | snakeToScream     | snakeToCamel     | snakeToPascal     |
| screaming | screamingToSnake | NA                | screamingToCamel | screamingToPascal |
| camel     | camleToSnake     | camelToScreaming  | NA               | camelToPascal     |
| pascal    | pascalToSnake    | pascalToScreaming | pascalToCamel    | NA                |

# Transformations
- snake to screaming
  - uppercasing all letters
- snake to camel
  - remove underscores
  - uppercase starting letters for new words after the first
- snake to pascal
  - remove underscores
  - uppercase starting letter for individual words, including first

- screaming to snake
  - lowercase all letters
- screaming to camel
  - remove underscores
  - lowercase all letters but first letter of individual words after the first
- screaming to pascal
  - remove underscores
  - lowercase all letters but first letter of individual words, including first

- camel to snake
  - add underscores
  - lowercase all letters
- camel to screaming
  - add underscores
  - uppercase all letters
- camel to pascal
  - uppercase first letter of variable

- pascal to snake
  - add underscores
  - lowercase all letters
- pascal to screaming
  - add underscores
  - uppercase all letters
- pascal to camel
  - lowercase first letter

# Shared Transformations
- remove underscores
- uppercase all individual word first letter (overload?)
- uppercase individual word first letter except for first word (overload?)
- lowercase all letters
  - capability built in to Java
- uppercase all letters
  - capability built in to Java
- add underscores
- **camel & pascal to snake and/or screaming can use the same method**