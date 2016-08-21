# Pattern matching for .cto filetype
## Vertices

```
([0-9a-f]{4}):(\d+(?:\.\d+)?),(\d+(?:\.\d+)?)
```
__Group 01:__ Vertex identifier  
__Group 02:__ X-coordinate  
__Group 03:__ Y-coordinate

## Triangles
```
\(([0-9a-f]{4}),([0-9a-f]{4}),([0-9a-f]{4})\)(?::([0-9a-f]{6}))?
```
__Group 01:__ Identifier of first vertex
__Group 02:__ Identifier of second vertex
__Group 03:__ Identifier of third vertex
__Group 04:__ Hex color code used for filling (optional)