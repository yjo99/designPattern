#import "Common/ShaderLib/GLSLCompat.glsllib"
#if defined(NEED_TEXCOORD1) 
    varying vec2 texCoord1;
#else 
    varying vec2 texCoord;
#endif


#ifdef HAS_GLOWMAP
  uniform sampler2D m_GlowMap;
#endif

#ifdef HAS_GLOWCOLOR
  uniform vec4 m_GlowColor;
#endif


void main(){
    #ifdef HAS_GLOWMAP
        #ifdef HAS_GLOWCOLOR
           vec4 color = m_GlowColor;
        #else
           vec4 color = vec4(1.0);
        #endif

        #if defined(NEED_TEXCOORD1) 
           gl_FragColor = texture2D(m_GlowMap, texCoord1) * color;
        #else 
           gl_FragColor = texture2D(m_GlowMap, texCoord) * color;
        #endif
    #else
        #ifdef HAS_GLOWCOLOR
            gl_FragColor =  m_GlowColor;
        #else
            gl_FragColor = vec4(0.0);
        #endif
    #endif
}