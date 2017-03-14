## Testing of currency conversion

### How to run?

#### Maven version must be 3.1.1 or above
```
1. git clone https://github.com/bazeeff/convertor-test.git
```
```
2. cd convertor-test
```
```
3. mvn clean install
```
```
4. mvn clean test site
```
```
5. mvn -Dorg.eclipse.jetty.annotations.maxWait=120 jetty:run
```
```
6. open in browser URL: http://localhost:8080/
```
#### P.S. The TCP port 8080 must be open in order to use.
