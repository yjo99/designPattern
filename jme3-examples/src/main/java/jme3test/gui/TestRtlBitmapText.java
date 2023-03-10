/*
 * Copyright (c) 2009-2021 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package jme3test.gui;

import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.font.*;

/**
 * Test case for JME issue #1158: BitmapText right to left line wrapping not work
 */
public class TestRtlBitmapText extends SimpleApplication {

    private String text = "This is a test right to left text.";
    private BitmapFont fnt;
    private BitmapText txt;

    public static void main(String[] args) {
        TestRtlBitmapText app = new TestRtlBitmapText();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        float x = 400;
        float y = 500;
        getStateManager().detach(stateManager.getState(StatsAppState.class));
        fnt = assetManager.loadFont("Interface/Fonts/Default.fnt");
        fnt.setRightToLeft(true);

        // A right to left BitmapText
        txt = new BitmapText(fnt);
        txt.setBox(new Rectangle(0, 0, 150, 0));
        txt.setLineWrapMode(LineWrapMode.Word);
        txt.setAlignment(BitmapFont.Align.Right);
        txt.setText(text);

        txt.setLocalTranslation(x, y, 0);
        guiNode.attachChild(txt);
    }
}
