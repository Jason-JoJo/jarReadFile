# jarReadFile
springboot read file in jar 

```
InputStream is = this.getClass().getClassLoader().getResourceAsStream("static/file/1.txt");
```
IDE OK, jar OK

---
```
ClassPathResource resource = new ClassPathResource("static/file/1.txt");
```
IDE OK, jar not work


---
ref:
https://stackoverflow.com/questions/51645295/how-to-specify-the-path-for-getresourceasstream-method-in-java
